package ntnu.fullstacksuperteam.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.ScoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing quiz scores. Provides functionality to retrieve and save score records for quizzes.
 */
@Service
public class ScoresService {
    @Autowired
    private ScoresRepository scoresRepository;

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(ScoresService.class);

    /**
     * Retrieves a list of {@link Score} records for a given user and quiz, ordered by date in descending order.
     *
     * @param userId The ID of the user.
     * @param quizId The ID of the quiz.
     * @return A list of scores for the specified user and quiz.
     */
    public List<Score> getScoresByUserAndQuizId(long userId, long quizId) {
        return scoresRepository.findAllByUserIdAndQuizIdOrderByDateDesc(userId, quizId);
    }

    /**
     * Retrieves a list of {@link Score} records for a given quiz, ordered by points and date in descending order.
     *
     * @param quizId The ID of the quiz.
     * @return A list of scores for the specified quiz.
     */
    public List<Score> getScoresByQuizId(long quizId) {
        return scoresRepository.findAllByQuizIdOrderByPointsDescDateDesc(quizId);
    }

    /**
     * Saves a {@link Score} record for a given user and quiz.
     *
     * @param userId The ID of the user.
     * @param quizId The ID of the quiz.
     * @param score The score object to be saved.
     * @return The saved score record.
     */
    public Score saveScore(long userId, long quizId, Score score) {
        User user = this.userService.getUserById(userId);
        Quiz quiz = entityManager.getReference(Quiz.class, quizId);
        score.setUser(user);
        score.setQuiz(quiz);
        return scoresRepository.save(score);
    }

    /**
     * Retrieves a list of {@link Score} records for a given user, ordered by date in descending order.
     *
     * @param userId The ID of the user.
     * @return A list of scores for the specified user.
     */
    public List<Score> getScoresByUserId(long userId) {
        return scoresRepository.findAllByUserIdOrderByDateDesc(userId);
    }
}
