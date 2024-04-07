package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

  private User user;
  private final List<Score> testScores = Arrays.asList(new Score(), new Score()); // Assuming Score is a simple entity
  private final Date testDate = new Date();

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @Test
  void testIdSetterAndGetter() {
    user.setId(1L);
    assertEquals(1L, user.getId(), "Id should be correctly set and retrieved");
  }

  @Test
  void testFirstNameSetterAndGetter() {
    user.setFirstName("John");
    assertEquals("John", user.getFirstName(), "First name should be correctly set and retrieved");
  }

  @Test
  void testLastNameSetterAndGetter() {
    user.setLastName("Doe");
    assertEquals("Doe", user.getLastName(), "Last name should be correctly set and retrieved");
  }

  @Test
  void testUsernameSetterAndGetter() {
    user.setUsername("johndoe");
    assertEquals("johndoe", user.getUsername(), "Username should be correctly set and retrieved");
  }

  @Test
  void testEmailSetterAndGetter() {
    user.setEmail("john.doe@example.com");
    assertEquals("john.doe@example.com", user.getEmail(), "Email should be correctly set and retrieved");
  }

  @Test
  void testPasswordSetterAndGetter() {
    user.setPassword("password123");
    assertEquals("password123", user.getPassword(), "Password should be correctly set and retrieved");
  }


  @Test
  void testScoreListSetterAndGetter() {
    user.setScoreList(testScores);
    assertEquals(testScores, user.getScoreList(), "ScoreList should be correctly set and retrieved");
    assertEquals(2, user.getScoreList().size(), "ScoreList size should be correct");
  }
}
