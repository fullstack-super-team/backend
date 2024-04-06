package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.FeedbackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

  @Mock
  private FeedbackRepository feedbackRepository;

  @Mock
  private UserService userService;

  @InjectMocks
  private FeedbackService feedbackService;

  private Feedback feedback;
  private User user;

  @BeforeEach
  void setUp() {
    // Initializing the User and Feedback objects for testing
    user = new User(); // Assuming User has a default constructor or setup appropriately
    user.setId(1L); // Simulate setting an ID for the user

    feedback = new Feedback(); // Assuming Feedback has a default constructor
    // Setup feedback as needed, for example, feedback.setText("Great service!");
  }

  @Test
  void testSaveFeedback() {
    // Setup stubbing for userService.getUserById
    when(userService.getUserById(anyLong())).thenReturn(user);
    // Assume feedbackRepository.save returns the passed feedback for simplicity
    when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

    Feedback savedFeedback = feedbackService.saveFeedback(1L, feedback);

    // Verify userService.getUserById was called correctly
    verify(userService, times(1)).getUserById(1L);
    // Verify feedbackRepository.save was called correctly
    verify(feedbackRepository, times(1)).save(feedback);
    // Assert that the returned feedback is the same as what was passed in
    assertEquals(feedback, savedFeedback, "The saved feedback should be returned");
    // Assert that the feedback's user is set correctly
    assertEquals(user, savedFeedback.getUser(), "The feedback's user should be set to the retrieved user");
  }
}
