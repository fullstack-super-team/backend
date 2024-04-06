package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

  private Question question;
  private Quiz testQuiz;
  private final Date testDate = new Date();

  @BeforeEach
  void setUp() {
    question = new Question();

    // Mocking Quiz object for testing
    testQuiz = new Quiz();
    testQuiz.setId(1L);
    // Additional setup for the testQuiz as needed
  }

  @Test
  void testIdSetterAndGetter() {
    question.setId(1L);
    assertEquals(1L, question.getId(), "Id should be correctly set and retrieved");
  }

  @Test
  void testTextSetterAndGetter() {
    question.setText("What is the capital of France?");
    assertEquals("What is the capital of France?", question.getText(), "Text should be correctly set and retrieved");
  }

  @Test
  void testQuizSetterAndGetter() {
    question.setQuiz(testQuiz);
    assertEquals(testQuiz, question.getQuiz(), "Quiz should be correctly set and retrieved");
  }

  @Test
  void testPointsSetterAndGetter() {
    question.setPoints(10);
    assertEquals(10, question.getPoints(), "Points should be correctly set and retrieved");
  }

  @Test
  void testMultimediaUrlSetterAndGetter() {
    question.setMultimediaUrl("http://example.com/image.png");
    assertEquals("http://example.com/image.png", question.getMultimediaUrl(), "Multimedia URL should be correctly set and retrieved");
  }


  @Test
  void testCopyConstructor() {
    question.setId(1L);
    question.setText("Sample Question");
    question.setQuiz(testQuiz);
    question.setPoints(5);
    question.setMultimediaUrl("http://example.com/video.mp4");

    Question copiedQuestion = new Question(question);

    assertAll("Testing copy constructor",
            () -> assertEquals(question.getId(), copiedQuestion.getId(), "ID should match"),
            () -> assertEquals(question.getText(), copiedQuestion.getText(), "Text should match"),
            () -> assertEquals(question.getQuiz(), copiedQuestion.getQuiz(), "Quiz should match"),
            () -> assertEquals(question.getPoints(), copiedQuestion.getPoints(), "Points should match"),
            () -> assertEquals(question.getMultimediaUrl(), copiedQuestion.getMultimediaUrl(), "Multimedia URL should match"),
            () -> assertEquals(question.getCreatedAt(), copiedQuestion.getCreatedAt(), "CreatedAt should match"),
            () -> assertEquals(question.getUpdatedAt(), copiedQuestion.getUpdatedAt(), "UpdatedAt should match")
    );
  }
}
