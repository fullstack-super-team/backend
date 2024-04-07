package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlideAnswerDTOTest {
  private SlideAnswerDTO slideAnswerDTO;

  @BeforeEach
  public void setUp() {
    slideAnswerDTO = new SlideAnswerDTO();
    slideAnswerDTO.setId(1L);
    slideAnswerDTO.setMin(0);
    slideAnswerDTO.setMax(100);
    slideAnswerDTO.setCorrectValue(50);
    slideAnswerDTO.setStepSize(10);
  }

  @Test
  public void testGetIdReturnsCorrectId() {
    assertEquals(1L, slideAnswerDTO.getId(), "getId() should return the correct id.");
  }

  @Test
  public void testGetMinReturnsCorrectMin() {
    assertEquals(0, slideAnswerDTO.getMin(), "getMin() should return the correct minimum value.");
  }

  @Test
  public void testGetMaxReturnsCorrectMax() {
    assertEquals(100, slideAnswerDTO.getMax(), "getMax() should return the correct maximum value.");
  }

  @Test
  public void testGetCorrectValueReturnsCorrectValue() {
    assertEquals(50, slideAnswerDTO.getCorrectValue(), "getCorrectValue() should return the correct value.");
  }

  @Test
  public void testGetStepSizeReturnsCorrectStepSize() {
    assertEquals(10, slideAnswerDTO.getStepSize(), "getStepSize() should return the correct step size.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    String expected = "SlideAnswerDTO{min=0, max=100, correctValue=50, steps=10}";
    assertEquals(expected, slideAnswerDTO.toString(), "toString() should return the correct string representation.");
  }
}
