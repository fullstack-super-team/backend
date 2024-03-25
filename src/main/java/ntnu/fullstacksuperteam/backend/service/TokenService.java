package ntnu.fullstacksuperteam.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    public String keyStr;
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);
    private final Logger logger = LoggerFactory.getLogger(TokenService.class);

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
