package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrueOrFalseQuestionTest {

  private TrueOrFalseQuestion trueOrFalseQuestion;
  private TrueOrFalseAnswer answer1;
  private TrueOrFalseAnswer answer2;

  @BeforeEach
  void setUp() {
    trueOrFalseQuestion = new TrueOrFalseQuestion();

    // Initializing TrueOrFalseAnswer objects for testing
    answer1 = new TrueOrFalseAnswer();
    answer1.setText("True");
    answer1.setIsCorrect(true);

    answer2 = new TrueOrFalseAnswer();
    answer2.setText("False");
    answer2.setIsCorrect(false);
  }

  @Test
  void testAddAnswer() {
    trueOrFalseQuestion.addAnswer(answer1);
    assertEquals(1, trueOrFalseQuestion.getAnswers().size(), "Adding an answer should increase answers list size");
    assertEquals(answer1, trueOrFalseQuestion.getAnswers().get(0), "The added answer should match the answer in the list");
  }

  @Test
  void testSetAnswers() {
    List<TrueOrFalseAnswer> answers = Arrays.asList(answer1, answer2);
    trueOrFalseQuestion.setAnswers(answers);
    assertEquals(answers, trueOrFalseQuestion.getAnswers(), "Set answers should match the given list of answers");
    assertEquals(2, trueOrFalseQuestion.getAnswers().size(), "Answers list should contain exactly two answers");
  }
}
