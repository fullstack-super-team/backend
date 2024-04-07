package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SlideQuestionDTOTest {
  private SlideQuestionDTO slideQuestionDTO;
  private SlideAnswerDTO slideAnswerDTO;

  @BeforeEach
  public void setUp() {
    slideQuestionDTO = new SlideQuestionDTO();
    slideAnswerDTO = new SlideAnswerDTO();
    slideAnswerDTO.setId(1L);
    slideAnswerDTO.setMin(0);
    slideAnswerDTO.setMax(100);
    slideAnswerDTO.setCorrectValue(50);
    slideAnswerDTO.setStepSize(10);

    slideQuestionDTO.setAnswer(slideAnswerDTO);
  }

  @Test
  public void testGetSlideAnswerDTOReturnsCorrectAnswer() {
    assertNotNull(slideQuestionDTO.getSlideAnswerDTO(), "getSlideAnswerDTO() should not return null.");
    assertEquals(slideAnswerDTO, slideQuestionDTO.getSlideAnswerDTO(), "getSlideAnswerDTO() should return the correct SlideAnswerDTO object.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    String expected = "CreateSlideQuestionDTO{slideAnswerDTO=" + slideAnswerDTO.toString() + "}";
    assertEquals(expected, slideQuestionDTO.toString(), "toString() should return the correct string representation.");
  }
}
