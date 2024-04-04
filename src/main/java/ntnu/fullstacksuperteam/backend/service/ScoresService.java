package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.model.Scores;
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

    public List<Scores> getScoresByUserAndQuizId(long userId, long quizId) {
        return scoresRepository.findAllByUserIdAndQuizId(userId, quizId);
    }

    public List<Scores> getScoresByQuizId(long quizId) {
        return scoresRepository.findAllByQuizId(quizId);
    }

    public Scores saveScores(Scores scores) {
        return scoresRepository.save(scores);
    }
}
