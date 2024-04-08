package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Provides access to the Quiz database table, extending JpaRepository for
 * standard CRUD operations.
 */
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    /**
     * Retrieves all quizzes created by a specified author.
     *
     * @param author The User object representing the author of the quizzes.
     * @return A list of quizzes created by the given author.
     */
    List<Quiz> findAllByAuthor(User author);

    /**
     * Finds quizzes whose titles contain the given search query.
     *
     * @param query The string to search for within quiz titles.
     * @return A list of quizzes with titles containing the specified query.
     */
    List<Quiz> findAllByTitleContaining(String query);
}
