package ntnu.fullstacksuperteam.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

  private Feedback feedback;
  private User testUser;
  private final Date testDate = new Date();

  @BeforeEach
  void setUp() {
    feedback = new Feedback();

    // Mocking User object for testing
    testUser = new User();
    testUser.setId(1L);
    testUser.setFirstName("John");
    testUser.setLastName("Doe");
    testUser.setUsername("johndoe");
    testUser.setEmail("john.doe@example.com");
    testUser.setPassword("securepassword");
  }

  @Test
  void testIdSetterAndGetter() {
    feedback.setId(1L);
    assertEquals(1L, feedback.getId(), "Id should be correctly set and retrieved");
  }

  @Test
  void testUserSetterAndGetter() {
    feedback.setUser(testUser);
    assertEquals(testUser, feedback.getUser(), "User should be correctly set and retrieved");
  }

  @Test
  void testCommentSetterAndGetter() {
    String comment = "Great job!";
    feedback.setComment(comment);
    assertEquals(comment, feedback.getComment(), "Comment should be correctly set and retrieved");
  }


  @Test
  void testToString() {
    feedback.setId(1L);
    feedback.setUser(testUser);
    feedback.setComment("Great job!");

    String expected = "Feedback: id=1, user=" + testUser.toString() + ", comment=Great job!";
    assertEquals(expected, feedback.toString(), "ToString should return the correct representation");
  }
}
