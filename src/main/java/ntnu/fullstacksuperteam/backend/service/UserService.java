package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.UserDTO;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user.get();
    }

    public User updateUser(long userId, User newUserInfo) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        User user = userOptional.get();
        Optional<User> existingUser = userRepository.findFirstByUsernameOrEmail(newUserInfo.getUsername(), newUserInfo.getEmail());
        if (existingUser.isPresent() && existingUser.get().getId() != userId) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username or email already exists");
        }
        System.out.println(newUserInfo.getFirstName());
        user.setFirstName(newUserInfo.getFirstName());
        user.setLastName(newUserInfo.getLastName());
        user.setUsername(newUserInfo.getUsername());
        user.setEmail(newUserInfo.getEmail());
        return userRepository.save(user);
    }
}
