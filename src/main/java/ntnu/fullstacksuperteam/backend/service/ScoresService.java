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

@Service
public class ScoresService {
    @Autowired
    private ScoresRepository scoresRepository;

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(ScoresService.class);

    public List<Score> getScoresByUserAndQuizId(long userId, long quizId) {
        return scoresRepository.findAllByUserIdAndQuizIdOrderByDateDesc(userId, quizId);
    }

    public List<Score> getScoresByQuizId(long quizId) {
        return scoresRepository.findAllByQuizIdOrderByPointsDescDateDesc(quizId);
    }

    public Score saveScore(long userId, long quizId, Score score) {
        User user = this.userService.getUserById(userId);
        Quiz quiz = entityManager.getReference(Quiz.class, quizId);
        score.setUser(user);
        score.setQuiz(quiz);
        return scoresRepository.save(score);
    }
}
