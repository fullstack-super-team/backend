package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import ntnu.fullstacksuperteam.backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The {@code FeedbackController} class is responsible for handling feedback-related requests..
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

  private final FeedbackService feedbackService;

  /**
   * Constructs a {@code FeedbackController} with the necessary {@code FeedbackService}.
   *
   * @param feedbackService The service to handle feedback-related operations.
   */
  @Autowired
  public FeedbackController(FeedbackService feedbackService) {
    this.feedbackService = feedbackService;
  }

  /**
   * Submits user feedback to the system. The user's identity is extracted from the {@code Authentication} object.
   *
   * @param authentication The security context containing information about the current user.
   * @param feedback The feedback provided by the user.
   * @return A {@code ResponseEntity} containing the saved feedback object.
   */
  @PostMapping
  public ResponseEntity<Feedback> submitFeedback(Authentication authentication, @RequestBody Feedback feedback) {
    long userId = Long.parseLong((String) authentication.getPrincipal());
    Feedback savedFeedback = feedbackService.saveFeedback(userId, feedback);
    return ResponseEntity.ok(savedFeedback);
  }
}
