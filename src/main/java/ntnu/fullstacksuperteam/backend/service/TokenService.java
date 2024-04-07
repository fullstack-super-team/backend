package ntnu.fullstacksuperteam.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

/**
 * Service class for generating and verifying JWT (JSON Web Tokens) tokens.
 *
 */
@Component
public class TokenService {
    @Value("${jwt.secret}")
    public String keyStr;
    private final Logger logger = LoggerFactory.getLogger(TokenService.class);
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofDays(90);

    /**
     * Generates a JWT token for a specified user ID with a validity of 90 days.
     *
     * @param userId The user ID for which the token will be generated.
     * @return A JWT token as a String.
     */
    public String generateToken(final Long userId) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);
        return JWT.create()
                .withSubject(userId.toString())
                .withIssuer("fst_token_issuer_app") // fst - fullstack super team
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(hmac512);
    }

    /**
     * Verifies the given JWT token's validity and returns the user ID encoded within it.
     *
     * @param token The JWT token to verify.
     * @return The user ID as a String if the token is valid, otherwise {@code null}.
     */
    public String verifyTokenAndGetUserId(final String token) {
        try {
            final Algorithm hmac512 = Algorithm.HMAC512(keyStr);
            final JWTVerifier verifier = JWT.require(hmac512).build();
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationException) {
            logger.warn("Token is invalid: {}", verificationException.getMessage());
            return null;
        }
    }
}
