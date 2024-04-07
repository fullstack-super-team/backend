package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmitAnswerDTOTest {
  private SubmitAnswerDTO submitAnswerDTO;

  @BeforeEach
  public void setUp() {
    submitAnswerDTO = new SubmitAnswerDTO();
  }

  @Test
  public void testAnswerSetterAndGetter() {
    String expectedAnswer = "42";
    submitAnswerDTO.setAnswer(expectedAnswer);
    assertEquals(expectedAnswer, submitAnswerDTO.getAnswer(), "getAnswer() should return the value set by setAnswer().");
  }
}
