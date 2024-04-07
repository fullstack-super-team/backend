package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionDTOTest {
  private QuestionDTO questionDTO;

  @BeforeEach
  public void setUp() {
    questionDTO = new QuestionDTO();
    questionDTO.setId(1L);
    questionDTO.setText("What is the capital of France?");
    questionDTO.setPoints(10);
    questionDTO.setMultimediaUrl("http://example.com/image.jpg");
    questionDTO.setType("TEXT");
  }

  @Test
  public void testGetIdReturnsCorrectId() {
    assertEquals(1L, questionDTO.getId(), "getId() should return the correct id.");
  }

  @Test
  public void testGetTextReturnsCorrectText() {
    assertEquals("What is the capital of France?", questionDTO.getText(), "getText() should return the correct text.");
  }

  @Test
  public void testGetPointsReturnsCorrectPoints() {
    assertEquals(10, questionDTO.getPoints(), "getPoints() should return the correct points.");
  }

  @Test
  public void testGetMultimediaUrlReturnsCorrectUrl() {
    assertEquals("http://example.com/image.jpg", questionDTO.getMultimediaUrl(), "getMultimediaUrl() should return the correct URL.");
  }

  @Test
  public void testGetTypeReturnsCorrectType() {
    assertEquals("TEXT", questionDTO.getType(), "getType() should return the correct type.");
  }
}
