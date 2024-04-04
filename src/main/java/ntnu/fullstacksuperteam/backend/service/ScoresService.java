package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.repository.ScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresService {

    private final ScoresRepository scoresRepository;

    @Autowired
    public ScoresService(ScoresRepository scoresRepository) {
        this.scoresRepository = scoresRepository;
    }

    public List<Score> getScoresByUserAndQuizId(long userId, long quizId) {
        return scoresRepository.findAllByUserIdAndQuizId(userId, quizId);
    }

    public List<Score> getScoresByQuizId(long quizId) {
        return scoresRepository.findAllByQuizId(quizId);
    }

    public Score saveScores(Score score) {
        return scoresRepository.save(score);
    }
}
