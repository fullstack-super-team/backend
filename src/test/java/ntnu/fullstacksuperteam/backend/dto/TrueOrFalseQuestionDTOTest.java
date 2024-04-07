package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrueOrFalseQuestionDTOTest {
  private TrueOrFalseQuestionDTO trueOrFalseQuestionDTO;
  private TrueOrFalseAnswerDTO trueAnswer;
  private TrueOrFalseAnswerDTO falseAnswer;

  @BeforeEach
  public void setUp() {
    trueOrFalseQuestionDTO = new TrueOrFalseQuestionDTO();
    trueAnswer = new TrueOrFalseAnswerDTO();
    falseAnswer = new TrueOrFalseAnswerDTO();

    trueAnswer.setText("True Statement");
    falseAnswer.setText("False Statement");

    trueAnswer.setCorrect(true);
    falseAnswer.setCorrect(false);
  }

  @Test
  public void testSetAnswersWithTwoAnswers() {
    trueOrFalseQuestionDTO.setAnswers(Arrays.asList(trueAnswer, falseAnswer));
    assertEquals(2, trueOrFalseQuestionDTO.getTextAnswerDTOS().size(), "Should store exactly two answers.");
  }

  @Test
  public void testSetAnswersWithMoreThanTwoAnswers() {
    TrueOrFalseAnswerDTO extraAnswer = new TrueOrFalseAnswerDTO();
    assertThrows(IllegalArgumentException.class, () -> trueOrFalseQuestionDTO.setAnswers(Arrays.asList(trueAnswer, falseAnswer, extraAnswer)),
            "Setting more than two answers should throw IllegalArgumentException.");
  }

  @Test
  public void testSetAnswersWithLessThanTwoAnswers() {
    assertThrows(IllegalArgumentException.class, () -> trueOrFalseQuestionDTO.setAnswers(Collections.singletonList(trueAnswer)),
            "Setting less than two answers should throw IllegalArgumentException.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    trueOrFalseQuestionDTO.setAnswers(Arrays.asList(trueAnswer, falseAnswer));
    String expectedStart = "CreateTextQuestionDTO{answers=[";
    String result = trueOrFalseQuestionDTO.toString();
    assertEquals(true, result.startsWith(expectedStart), "The toString method should return a string that starts with the expected format.");
  }
}
