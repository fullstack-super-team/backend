package ntnu.fullstacksuperteam.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import ntnu.fullstacksuperteam.backend.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("Request URI is: {}", request.getRequestURI());
        // check Bearer auth header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // if Bearer auth header exists, validate token, and extract userId from token.
        // Note that we have added userId as subject to the token when it is generated
        // Note also that the token comes in this format 'Bearer token'
        String token = header.substring(7);
        final String userId = verifyTokenAndGetUserId(token);
        if (userId == null) {
            // validation failed or token expired
            filterChain.doFilter(request, response);
            return;
        }

        // if token is valid, add user details to the authentication context
        // Note that user details should be fetched from the database in real scenarios
        // this is case we will retrieve use details from mock
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                userId,
                null,
                null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // then, continue with authenticated user context
        filterChain.doFilter(request, response);
    }

    String verifyTokenAndGetUserId(final String token) {
        try {
            final Algorithm hmac512 = Algorithm.HMAC512(TokenService.keyStr);
            final JWTVerifier verifier = JWT.require(hmac512).build();
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationException) {
            logger.warn("Token is invalid: {}", verificationException.getMessage());
            return null;
        }
    }
}
