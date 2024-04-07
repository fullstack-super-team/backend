package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrueOrFalseAnswerTest {

  private TrueOrFalseAnswer trueOrFalseAnswer;

  @BeforeEach
  void setUp() {
    trueOrFalseAnswer = new TrueOrFalseAnswer();
  }

  @Test
  void testTextSetterAndGetter() {
    String exampleText = "This is an example explanation.";
    trueOrFalseAnswer.setText(exampleText);
    assertEquals(exampleText, trueOrFalseAnswer.getText(), "Text should be correctly set and retrieved");
  }

  @Test
  void testIsCorrectSetterAndGetter() {
    trueOrFalseAnswer.setIsCorrect(true);
    assertTrue(trueOrFalseAnswer.isIsCorrect(), "isCorrect (true) should be correctly set and retrieved");

    trueOrFalseAnswer.setIsCorrect(false);
    assertFalse(trueOrFalseAnswer.isIsCorrect(), "isCorrect (false) should be correctly set and retrieved");
  }
}
