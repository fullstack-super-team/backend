package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrueOrFalseAnswerDTOTest {
  private TrueOrFalseAnswerDTO trueAnswerDTO;
  private TrueOrFalseAnswerDTO falseAnswerDTO;

  @BeforeEach
  public void setUp() {
    trueAnswerDTO = new TrueOrFalseAnswerDTO();
    trueAnswerDTO.setId(1L);
    trueAnswerDTO.setText("The earth is flat.");
    trueAnswerDTO.setCorrect(false);

    falseAnswerDTO = new TrueOrFalseAnswerDTO();
    falseAnswerDTO.setId(2L);
    falseAnswerDTO.setText("Water is wet.");
    falseAnswerDTO.setCorrect(true);
  }

  @Test
  public void testTrueOrFalseAnswerDTOCorrectlyStoresFalse() {
    assertEquals(1L, trueAnswerDTO.getId(), "The ID should be correctly stored and returned.");
    assertEquals("The earth is flat.", trueAnswerDTO.getText(), "The text should be correctly stored and returned.");
    assertFalse(trueAnswerDTO.getIsCorrect(), "The isCorrect should be false for the first DTO.");
  }

  @Test
  public void testTrueOrFalseAnswerDTOCorrectlyStoresTrue() {
    assertEquals(2L, falseAnswerDTO.getId(), "The ID should be correctly stored and returned.");
    assertEquals("Water is wet.", falseAnswerDTO.getText(), "The text should be correctly stored and returned.");
    assertTrue(falseAnswerDTO.getIsCorrect(), "The isCorrect should be true for the second DTO.");
  }
}
