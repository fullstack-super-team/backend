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

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

  private final FeedbackService feedbackService;

  @Autowired
  public FeedbackController(FeedbackService feedbackService) {
    this.feedbackService = feedbackService;
  }

  @PostMapping
  public ResponseEntity<Feedback> submitFeedback(Authentication authentication, @RequestBody Feedback feedback) {
    long userId = Long.parseLong((String) authentication.getPrincipal());
    Feedback savedFeedback = feedbackService.saveFeedback(userId, feedback);
    return ResponseEntity.ok(savedFeedback);
  }
}
