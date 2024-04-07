package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import ntnu.fullstacksuperteam.backend.dto.LoginDTO;
import ntnu.fullstacksuperteam.backend.model.Token;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Service for handling authentication processes, including user registration and login.
 * Utilizes the UserRepository to interact with the database, PasswordEncoder for hashing passwords,
 * and TokenService for JWT generation and validation.
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user in the system based on provided registration details.
     * Validates the uniqueness of username and email before saving a new user.
     *
     * @param registerDTO Data Transfer Object containing the user's registration details.
     * @return A Token object containing a JWT for the newly registered user.
     * @throws ResponseStatusException with HttpStatus.CONFLICT if username or email is already in use.
     */
    public Token register(RegisterDTO registerDTO) throws ResponseStatusException {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findFirstByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail()).stream().findFirst();
        if (existingUser.isPresent() && existingUser.get().getUsername().equals(registerDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        if (existingUser.isPresent() && existingUser.get().getEmail().equals(registerDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        // If not then save
        User newUser = new User();
        newUser.setFirstName(registerDTO.getFirstName());
        newUser.setLastName(registerDTO.getLastName());
        newUser.setUsername(registerDTO.getUsername());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        User savedUser = userRepository.save(newUser);
        return new Token(tokenService.generateToken(savedUser.getId()));
    }

    /**
     * Authenticates a user based on their login credentials.
     * Verifies the email and password against stored values.
     * Throws a ResponseStatusException if authentication fails.
     *
     * @param loginDTO Data Transfer Object containing the user's login credentials.
     * @return A Token object containing a JWT for the authenticated user.
     * @throws ResponseStatusException with HttpStatus.UNAUTHORIZED if authentication fails.
     */
    public Token login(LoginDTO loginDTO) throws ResponseStatusException {
        // Check if username and password is correct
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null || !passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong credentials...");
        }

        return new Token(tokenService.generateToken(user.getId()));
    }
}
