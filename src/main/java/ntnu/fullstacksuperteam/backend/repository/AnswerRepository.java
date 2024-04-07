package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AnswerRepository provides an abstract interface to some type of database or other persistence mechanism.
 * It extends {@link JpaRepository} to handle CRUD operations and queries for {@link Answer} entities.
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    /**
     * Retrieves a list of {@link Answer} entities associated with a specific question, identified by its ID.
     *
     * @param questionId The unique identifier of the question whose answers are to be retrieved.
     * @return A {@link List} of {@link Answer} objects associated with the specified question ID.
     */
    List<Answer> findAllByQuestionId(long questionId);

    /**
     * Finds a single {@link Answer} entity based on a question ID.
     *
     * @param questionId The unique identifier of the question for which the answer is to be retrieved.
     * @return An {@link Answer} object associated with the specified question ID, or {@code null} if no such answer exists.
     */
    Answer findByQuestionId(long questionId);
}
