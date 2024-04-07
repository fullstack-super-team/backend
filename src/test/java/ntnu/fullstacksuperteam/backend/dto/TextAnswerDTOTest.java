package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextAnswerDTOTest {
  private TextAnswerDTO textAnswerDTO;

  @BeforeEach
  public void setUp() {
    textAnswerDTO = new TextAnswerDTO();
    textAnswerDTO.setId(1L);
    textAnswerDTO.setText("Paris");
    textAnswerDTO.setCorrect(true);
  }

  @Test
  public void testGetIdReturnsCorrectId() {
    assertEquals(1L, textAnswerDTO.getId(), "getId() should return the correct id.");
  }

  @Test
  public void testGetTextReturnsCorrectText() {
    assertEquals("Paris", textAnswerDTO.getText(), "getText() should return the correct text.");
  }

  @Test
  public void testGetIsCorrectReturnsTrueWhenSetToTrue() {
    assertTrue(textAnswerDTO.getIsCorrect(), "getIsCorrect() should return true when set to true.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    String expected = "TextAnswerDTO{text='Paris', correct=true}";
    assertEquals(expected, textAnswerDTO.toString(), "toString() should return the correct string representation.");
  }
}
