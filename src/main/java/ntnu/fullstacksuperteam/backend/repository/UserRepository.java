package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
}
