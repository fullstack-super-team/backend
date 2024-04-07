package ntnu.fullstacksuperteam.backend.security;

import ntnu.fullstacksuperteam.backend.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/**
 * Filter for JWT (JSON Web Token) authorization that ensures only requests with a valid Bearer token
 * are authenticated.
 *
 * This class extends {@link OncePerRequestFilter} to ensure the filtering logic is applied once per request.
 */
@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    /**
     * Constructs a new JWTAuthorizationFilter with the specified {@link TokenService}.
     *
     * @param tokenService the TokenService to use for token verification.
     */
    @Autowired
    public JWTAuthorizationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * Filters incoming HTTP requests for JWT Bearer tokens in the Authorization header.
     *
     * @param request the request to filter
     * @param response the response associated with the request
     * @param filterChain the filter chain for request processing
     * @throws ServletException if an error occurs during request processing
     * @throws IOException if an I/O error occurs during request processing
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            logger.warn("No Bearer token found in request");
            return;
        }

        String token = header.substring(7);
        final String userId = tokenService.verifyTokenAndGetUserId(token);
        if (userId == null) {
            filterChain.doFilter(request, response);
            logger.warn("Token validation failed");
            return;
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                userId,
                null,
                null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }
}
