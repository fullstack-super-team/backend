package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
  private final UserService userService;
  private final FeedbackRepository feedbackRepository;

  @Autowired
  public FeedbackService(FeedbackRepository feedbackRepository, UserService userService) {
    this.feedbackRepository = feedbackRepository;
    this.userService = userService;
  }

  public Feedback saveFeedback(long userId, Feedback feedback) {
    User user = this.userService.getUserById(userId);
    feedback.setUser(user);
    return feedbackRepository.save(feedback);
  }
}
