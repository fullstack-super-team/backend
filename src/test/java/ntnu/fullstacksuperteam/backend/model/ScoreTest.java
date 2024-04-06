package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

  private Score score;
  private User testUser;
  private Quiz testQuiz;
  private final Date testDate = new Date();

  @BeforeEach
  void setUp() {
    score = new Score();

    // Mocking User object for testing
    testUser = new User();
    testUser.setId(1L);
    testUser.setFirstName("John");
    testUser.setLastName("Doe");
    testUser.setUsername("johndoe");
    testUser.setEmail("john.doe@example.com");
    testUser.setPassword("securepassword");

    // Mocking Quiz object for testing
    testQuiz = new Quiz();
    testQuiz.setId(1L);
    testQuiz.setTitle("Sample Quiz");
    // Additional setup for the testQuiz as needed
  }

  @Test
  void testUserSetterAndGetter() {
    score.setUser(testUser);
    assertEquals(testUser, score.getUser(), "User should be correctly set and retrieved");
  }

  @Test
  void testPointsSetterAndGetter() {
    score.setPoints(100);
    assertEquals(100, score.getPoints(), "Points should be correctly set and retrieved");
  }

  @Test
  void testQuizSetterAndGetter() {
    score.setQuiz(testQuiz);
    assertEquals(testQuiz, score.getQuiz(), "Quiz should be correctly set and retrieved");
  }
}
