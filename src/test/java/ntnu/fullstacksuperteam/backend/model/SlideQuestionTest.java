package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlideQuestionTest {

  private SlideQuestion slideQuestion;
  private SlideAnswer slideAnswer;

  @BeforeEach
  void setUp() {
    slideQuestion = new SlideQuestion();

    slideAnswer = new SlideAnswer();
    slideAnswer.setMin(0);
    slideAnswer.setMax(100);
    slideAnswer.setCorrectValue(50);
    slideAnswer.setStepSize(10);
  }

  @Test
  void testAnswerSetterAndGetter() {
    slideQuestion.setAnswer(slideAnswer);
    assertEquals(slideAnswer, slideQuestion.getAnswer(), "Answer should be correctly set and retrieved");

    assertAll("Verify properties of the attached SlideAnswer",
            () -> assertEquals(0, slideQuestion.getAnswer().getMin(), "Minimum value should match"),
            () -> assertEquals(100, slideQuestion.getAnswer().getMax(), "Maximum value should match"),
            () -> assertEquals(50, slideQuestion.getAnswer().getCorrectValue(), "Correct value should match"),
            () -> assertEquals(10, slideQuestion.getAnswer().getStepSize(), "Step size should match")
    );
  }
}
