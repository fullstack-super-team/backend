package ntnu.fullstacksuperteam.backend.repository;

import ntnu.fullstacksuperteam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for CRUD operations on User entities.
 * It extends JpaRepository, adding custom methods to find users by email or a combination of username and email.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User entity based on the provided email address.
     *
     * @param email The email address to search for.
     * @return The User entity associated with the provided email address, or {@code null} if no such user exists.
     */
    User findByEmail(String email);

    /**
     * Finds the first User entity that matches either the provided username or email.
     *
     * @param username The username to search for.
     * @param email The email address to search for.
     * @return An {@code Optional<User>} containing the found user, if any, or an empty Optional if no match is found.
     */
    Optional<User> findFirstByUsernameOrEmail(String username, String email);
}
