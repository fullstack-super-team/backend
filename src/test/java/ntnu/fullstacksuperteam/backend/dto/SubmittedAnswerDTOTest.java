package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmittedAnswerDTOTest {

  @Test
  public void testWithStringType() {
    // Arrange
    String submittedAnswer = "User's answer";
    String correctAnswers = "Correct answer";
    int pointsGiven = 10;
    SubmittedAnswerDTO<String> dto = new SubmittedAnswerDTO<>(submittedAnswer, correctAnswers, pointsGiven);

    // Act & Assert
    assertEquals(submittedAnswer, dto.getSubmittedAnswer(), "Submitted answer should match the input.");
    assertEquals(correctAnswers, dto.getCorrectAnswers(), "Correct answers should match the input.");
    assertEquals(pointsGiven, dto.getPointsGiven(), "Points given should match the input.");
  }

  @Test
  public void testWithIntegerType() {
    // Arrange
    Integer submittedAnswer = 5;
    Integer correctAnswers = 10;
    int pointsGiven = 5;
    SubmittedAnswerDTO<Integer> dto = new SubmittedAnswerDTO<>(submittedAnswer, correctAnswers, pointsGiven);

    // Act & Assert
    assertEquals(submittedAnswer, dto.getSubmittedAnswer(), "Submitted answer should match the input.");
    assertEquals(correctAnswers, dto.getCorrectAnswers(), "Correct answers should match the input.");
    assertEquals(pointsGiven, dto.getPointsGiven(), "Points given should match the input.");
  }
}
