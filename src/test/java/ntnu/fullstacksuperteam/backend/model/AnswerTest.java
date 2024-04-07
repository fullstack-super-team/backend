package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

  private AnswerTestImpl answer;
  private Question testQuestion;

  @BeforeEach
  void setUp() {
    // Initialize the concrete subclass of Answer
    answer = new AnswerTestImpl();

    // Setup a mock Question object
    // Assuming Question is another entity class related to Answer
    testQuestion = new Question();
    testQuestion.setId(1L); // Setting an example ID for the question
  }

  @Test
  void testIdSetterAndGetter() {
    answer.setId(1L);
    assertEquals(1L, answer.getId(), "Id should be correctly set and retrieved");
  }

  @Test
  void testQuestionSetterAndGetter() {
    answer.setQuestion(testQuestion);
    assertEquals(testQuestion, answer.getQuestion(), "Question should be correctly set and retrieved");
  }

  // Concrete subclass of Answer for testing purposes
  private static class AnswerTestImpl extends Answer {
    // No additional fields or methods required for basic testing
  }
}
