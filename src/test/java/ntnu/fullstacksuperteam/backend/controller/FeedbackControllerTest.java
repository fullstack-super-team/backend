package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import ntnu.fullstacksuperteam.backend.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FeedbackControllerTest {

  @Mock
  private FeedbackService feedbackService;

  @Mock
  private Authentication authentication;

  @InjectMocks
  private FeedbackController feedbackController;

  private Feedback feedback;
  private Feedback savedFeedback;

  @BeforeEach
  void setUp() {
    feedback = new Feedback();
    savedFeedback = new Feedback();
    when(authentication.getPrincipal()).thenReturn("1");
    when(feedbackService.saveFeedback(anyLong(), any(Feedback.class))).thenReturn(savedFeedback);
  }

  @Test
  void testSubmitFeedback() {
    ResponseEntity<Feedback> response = feedbackController.submitFeedback(authentication, feedback);

    assertNotNull(response);
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(savedFeedback, response.getBody());

    verify(feedbackService).saveFeedback(1L, feedback);
  }
}
