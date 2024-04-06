package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import ntnu.fullstacksuperteam.backend.dto.LoginDTO;
import ntnu.fullstacksuperteam.backend.model.Token;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    public Token register(RegisterDTO registerDTO) throws ResponseStatusException {
        // Check if user already exists
        User existingUser = userRepository.findByEmail(registerDTO.getEmail());
        if (existingUser != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists...");
        }

        // If not then save
        User newUser = new User();
        newUser.setFirstName(registerDTO.getFirstName());
        newUser.setLastName(registerDTO.getLastName());
        newUser.setUsername(registerDTO.getUsername());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setPassword(registerDTO.getPassword());
        User savedUser = userRepository.save(newUser);
        return new Token(tokenService.generateToken(savedUser.getId()));
    }

    public Token login(LoginDTO loginDTO) throws ResponseStatusException {
        // Check if username and password is correct
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find user...");
        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong credentials...");
        }
        return new Token(tokenService.generateToken(user.getId()));
    }
}
