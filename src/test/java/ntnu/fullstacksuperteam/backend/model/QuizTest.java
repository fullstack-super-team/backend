package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

  private Quiz quiz;
  private User testAuthor;
  private Question testQuestion;
  private final Date testDate = new Date();

  @BeforeEach
  void setUp() {
    quiz = new Quiz();

    // Mocking User object for testing
    testAuthor = new User();
    testAuthor.setId(1L);
    testAuthor.setFirstName("John");
    testAuthor.setLastName("Doe");
    testAuthor.setUsername("johndoe");
    testAuthor.setEmail("john.doe@example.com");
    testAuthor.setPassword("securepassword");

    // Mocking Question object for testing
    testQuestion = new Question();
    testQuestion.setId(1L);
    testQuestion.setText("Sample Question");
  }

  @Test
  void testIdSetterAndGetter() {
    quiz.setId(1L);
    assertEquals(1L, quiz.getId(), "Id should be correctly set and retrieved");
  }

  @Test
  void testTitleSetterAndGetter() {
    quiz.setTitle("Sample Quiz");
    assertEquals("Sample Quiz", quiz.getTitle(), "Title should be correctly set and retrieved");
  }

  @Test
  void testQuestionsSetterAndGetter() {
    quiz.setQuestions(Arrays.asList(testQuestion));
    assertEquals(1, quiz.getQuestions().size(), "Questions list should be correctly set and retrieved");
    assertEquals(testQuestion, quiz.getQuestions().get(0), "Question should match the one set");
  }


  @Test
  void testDifficultyLevelSetterAndGetter() {
    DifficultyLevel difficultyLevel = DifficultyLevel.EASY; // Assuming DifficultyLevel is an enum
    quiz.setDifficultyLevel(difficultyLevel);
    assertEquals(difficultyLevel, quiz.getDifficultyLevel(), "DifficultyLevel should be correctly set and retrieved");
  }

  @Test
  void testDescriptionSetterAndGetter() {
    quiz.setDescription("This is a description.");
    assertEquals("This is a description.", quiz.getDescription(), "Description should be correctly set and retrieved");
  }

  @Test
  void testAuthorSetterAndGetter() {
    quiz.setAuthor(testAuthor);
    assertEquals(testAuthor, quiz.getAuthor(), "Author should be correctly set and retrieved");
  }

  @Test
  void testCreatedAtSetter() {
    quiz.setCreatedAt(testDate);
    assertEquals(testDate, quiz.getCreatedAt(), "CreatedAt should be correctly set");
  }

  @Test
  void testUpdatedAtSetter() {
    quiz.setUpdatedAt(testDate);
    assertEquals(testDate, quiz.getUpdatedAt(), "UpdatedAt should be correctly set");
  }
}
