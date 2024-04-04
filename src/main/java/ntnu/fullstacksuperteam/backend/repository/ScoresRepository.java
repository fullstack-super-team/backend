package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoresRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByUserIdAndQuizId(long user, long quizId);
    List<Score> findAllByQuizId(long quizId);
}
