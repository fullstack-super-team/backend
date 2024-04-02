package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.Quiz;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
