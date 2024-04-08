package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing feedback operations.
 */
@Service
public class FeedbackService {
  private final UserService userService;
  private final FeedbackRepository feedbackRepository;

  /**
   * Constructs a FeedbackService.
   *
   * @param feedbackRepository The repository for performing feedback persistence operations.
   * @param userService The service for user-related queries and operations.
   */
  @Autowired
  public FeedbackService(FeedbackRepository feedbackRepository, UserService userService) {
    this.feedbackRepository = feedbackRepository;
    this.userService = userService;
  }

  /**
   * Saves a feedback instance to the database associated with a specific user.
   * The user is identified by their ID and linked to the feedback before saving.
   *
   * @param userId The ID of the user providing the feedback.
   * @param feedback The feedback object to be saved.
   * @return The saved Feedback entity, now containing a generated ID and associated with a user.
   */
  public Feedback saveFeedback(long userId, Feedback feedback) {
    User user = this.userService.getUserById(userId);
    feedback.setUser(user);
    return feedbackRepository.save(feedback);
  }
}
