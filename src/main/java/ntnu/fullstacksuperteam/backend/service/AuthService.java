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
    public Token register(RegisterDTO registerDTO) {
        try {
            // Check if user already exists

            // If not then save
            User savedUser = userRepository.save(new User(registerDTO));
            return new Token(tokenService.generateToken(savedUser.getUserId()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong...");
        }
    }

    public Token login(LoginDTO loginDTO) {
        // Check if username and password is correct
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong credentials...");
        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong credentials...");
        }
        return new Token(tokenService.generateToken(user.getUserId()));
    }
}
