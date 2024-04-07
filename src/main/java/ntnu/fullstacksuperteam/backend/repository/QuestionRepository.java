package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Manages storage and retrieval of Question entities.
 * Extends JpaRepository to provide standard CRUD operations and includes
 */
public interface QuestionRepository extends JpaRepository<Question, Long>{

    /**
     * Finds all questions linked to a given quiz.
     *
     * @param quizId The ID of the quiz.
     * @return A list of questions for the specified quiz.
     */
    List<Question> findByQuizId(long quizId);
}
