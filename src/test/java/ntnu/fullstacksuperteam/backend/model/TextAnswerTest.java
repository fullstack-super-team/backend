package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextAnswerTest {

  private TextAnswer textAnswer;

  @BeforeEach
  void setUp() {
    textAnswer = new TextAnswer();
  }

  @Test
  void testTextSetterAndGetter() {
    String exampleText = "Example answer text";
    textAnswer.setText(exampleText);
    assertEquals(exampleText, textAnswer.getText(), "Text should be correctly set and retrieved");
  }

  @Test
  void testIsCorrectSetterAndGetter() {
    textAnswer.setIsCorrect(true);
    assertTrue(textAnswer.isIsCorrect(), "isCorrect should be correctly set and retrieved");

    textAnswer.setIsCorrect(false);
    assertFalse(textAnswer.isIsCorrect(), "isCorrect should be correctly set and retrieved");
  }

  @Test
  void testToString() {
    String exampleText = "Example answer text";
    textAnswer.setText(exampleText);
    textAnswer.setIsCorrect(true);

    String expectedToString = "TextAnswer{text=Example answer text, correct=true}";
    assertEquals(expectedToString, textAnswer.toString(), "toString should return the correct string representation");
  }
}
