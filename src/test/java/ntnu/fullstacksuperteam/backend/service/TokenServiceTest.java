package ntnu.fullstacksuperteam.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

  private TokenService tokenService;

  private final String secretKey = "testSecretKey";

  @BeforeEach
  void setUp() {
    tokenService = new TokenService();
    // Manually set the secret key used by the token service
    ReflectionTestUtils.setField(tokenService, "keyStr", secretKey);
  }

  @Test
  void generateTokenSuccess() {
    Long userId = 1L;
    String token = tokenService.generateToken(userId);
    assertNotNull(token, "Generated token should not be null");

    // Verify the token using the same secret
    Algorithm algorithm = Algorithm.HMAC512(secretKey);
    String subject = JWT.require(algorithm).build().verify(token).getSubject();
    assertEquals(userId.toString(), subject, "The subject should match the user ID");
  }

  @Test
  void verifyTokenSuccess() {
    Long userId = 1L;
    // Generate token for verification
    String token = tokenService.generateToken(userId);

    String verifiedUserId = tokenService.verifyTokenAndGetUserId(token);
    assertNotNull(verifiedUserId, "Verification should succeed and return a user ID");
    assertEquals(userId.toString(), verifiedUserId, "Verified user ID should match the original");
  }

  @Test
  void verifyTokenFailure() {
    // Use an invalid token for verification
    String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxIiwiaXNzIjoiZnN0X3Rva2VuX2lzc3Vlcl9hcHAifQ.invalid_signature";

    String result = tokenService.verifyTokenAndGetUserId(invalidToken);
    assertNull(result, "Verification of an invalid token should fail and return null");
  }
}
