package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

  @Test
  void testTokenConstructorAndGetter() {
    String expectedToken = "abc123";
    Token token = new Token(expectedToken);
    assertEquals(expectedToken, token.getToken(), "The getToken method should return the value set by the constructor");
  }
}
