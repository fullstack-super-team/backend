package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTest {

  @Test
  public void testGetMessageReturnsCorrectMessage() {
    // Arrange
    String expectedMessage = "An error occurred";
    ErrorResponse errorResponse = new ErrorResponse(expectedMessage);

    // Act
    String actualMessage = errorResponse.getMessage();

    // Assert
    assertEquals(expectedMessage, actualMessage, "The message returned by getMessage() was not the same as the one passed to the constructor.");
  }
}
