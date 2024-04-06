package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextQuestionTest {

  private TextQuestion textQuestion;
  private TextAnswer answer1;
  private TextAnswer answer2;

  @BeforeEach
  void setUp() {
    textQuestion = new TextQuestion();

    // Initializing TextAnswer objects for testing
    answer1 = new TextAnswer();
    answer1.setText("Answer 1");
    answer1.setIsCorrect(true);

    answer2 = new TextAnswer();
    answer2.setText("Answer 2");
    answer2.setIsCorrect(false);
  }

  @Test
  void testAddAnswer() {
    textQuestion.addAnswer(answer1);
    assertEquals(1, textQuestion.getAnswers().size(), "Adding an answer should increase answers list size");
    assertEquals(answer1, textQuestion.getAnswers().get(0), "The added answer should match the answer in the list");
  }

  @Test
  void testSetAnswers() {
    List<TextAnswer> answers = Arrays.asList(answer1, answer2);
    textQuestion.setAnswers(answers);
    assertEquals(answers, textQuestion.getAnswers(), "Set answers should match the given list of answers");
    assertEquals(2, textQuestion.getAnswers().size(), "Answers list should contain exactly two answers");
  }
}
