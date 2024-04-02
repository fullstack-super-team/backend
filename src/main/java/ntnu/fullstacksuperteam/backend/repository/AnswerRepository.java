package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(long questionId);
    Answer findByQuestionId(long questionId);
}
