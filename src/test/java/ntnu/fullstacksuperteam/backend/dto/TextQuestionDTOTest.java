package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextQuestionDTOTest {
  private TextQuestionDTO textQuestionDTO;
  private List<TextAnswerDTO> answers;

  @BeforeEach
  public void setUp() {
    textQuestionDTO = new TextQuestionDTO();
    TextAnswerDTO answer1 = new TextAnswerDTO();
    answer1.setText("Answer 1");
    answer1.setCorrect(true);

    TextAnswerDTO answer2 = new TextAnswerDTO();
    answer2.setText("Answer 2");
    answer2.setCorrect(false);

    answers = Arrays.asList(answer1, answer2);
    textQuestionDTO.setAnswers(answers);
  }

  @Test
  public void testGetTextAnswerDTOSReturnsCorrectAnswers() {
    List<TextAnswerDTO> retrievedAnswers = textQuestionDTO.getTextAnswerDTOS();
    assertNotNull(retrievedAnswers, "The list of answers should not be null.");
    assertEquals(2, retrievedAnswers.size(), "The list of answers should contain exactly 2 elements.");
    assertTrue(retrievedAnswers.containsAll(answers), "The retrieved answers should match the ones that were set.");
  }

  @Test
  public void testSettingEmptyList() {
    textQuestionDTO.setAnswers(Collections.emptyList());
    assertNotNull(textQuestionDTO.getTextAnswerDTOS(), "Setting an empty list should still result in a non-null list being retrieved.");
    assertTrue(textQuestionDTO.getTextAnswerDTOS().isEmpty(), "The retrieved list should be empty when an empty list was set.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    String expectedStart = "CreateTextQuestionDTO{answers=[";
    String result = textQuestionDTO.toString();
    assertTrue(result.startsWith(expectedStart), "The toString method should return a string that starts with the expected format.");
  }
}
