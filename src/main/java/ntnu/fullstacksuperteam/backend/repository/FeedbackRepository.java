package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Handles database operations for Feedback entities.
 * Inherits common CRUD operations from JpaRepository.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
