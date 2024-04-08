package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Facilitates CRUD operations and custom queries for Score entities within the database.
 * Extends the JpaRepository to leverage Spring Data JPA's built-in functionalities.
 */
public interface ScoresRepository extends JpaRepository<Score, Long> {


    /**
     * Retrieves a list of Score records for a specific user and quiz, ordered by the date they were recorded in descending order.
     *
     * @param user The unique identifier of the user.
     * @param quizId The unique identifier of the quiz.
     * @return A list of Score objects, sorted by the date of attempt from most recent to oldest.
     */
    List<Score> findAllByUserIdAndQuizIdOrderByDateDesc(long user, long quizId);

    /**
     * Retrieves a list of Score records for a specific quiz, ordered first by points in descending order for high score ranking,
     * and then by date in descending order to show the newest scores first among those with the same points.
     *
     * @param quizId The unique identifier of the quiz for which scores are queried.
     * @return A list of Score objects for the specified quiz, sorted to facilitate leaderboard creation.
     */
    List<Score> findAllByQuizIdOrderByPointsDescDateDesc(long quizId);

    /**
     * Retrieves a list of Score records for a specific user, ordered by the date they were recorded in descending order.
     *
     * @param userId The unique identifier of the user.
     * @return A list of Score objects for the specified user, showing their scoring history from most recent to oldest.
     */
    List<Score> findAllByUserIdOrderByDateDesc(long userId);
}
