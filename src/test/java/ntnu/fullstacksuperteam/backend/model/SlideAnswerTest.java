package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlideAnswerTest {

  private SlideAnswer slideAnswer;

  @BeforeEach
  void setUp() {
    slideAnswer = new SlideAnswer();
  }

  @Test
  void testMinSetterAndGetter() {
    slideAnswer.setMin(0);
    assertEquals(0, slideAnswer.getMin(), "Minimum value should be correctly set and retrieved");
  }

  @Test
  void testMaxSetterAndGetter() {
    slideAnswer.setMax(10);
    assertEquals(10, slideAnswer.getMax(), "Maximum value should be correctly set and retrieved");
  }

  @Test
  void testCorrectValueSetterAndGetter() {
    slideAnswer.setCorrectValue(5);
    assertEquals(5, slideAnswer.getCorrectValue(), "Correct value should be correctly set and retrieved");
  }

  @Test
  void testStepSizeSetterAndGetter() {
    slideAnswer.setStepSize(1);
    assertEquals(1, slideAnswer.getStepSize(), "Step size should be correctly set and retrieved");
  }
}
