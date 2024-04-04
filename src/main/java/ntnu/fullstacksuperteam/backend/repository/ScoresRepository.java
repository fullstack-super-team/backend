package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Scores;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoresRepository extends JpaRepository<Scores, Long> {
    List<Scores> findAllByUserIdAndQuizId(long user, long quizId);
    List<Scores> findAllByQuizId(long quizId);
}
