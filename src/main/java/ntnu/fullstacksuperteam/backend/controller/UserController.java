package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.UserDTO;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * The {@code UserController} class is responsible for user-related operations,
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * Retrieves the current user's information.
     *
     * @param authentication The security context that contains details about the current user.
     * @return A {@code ResponseEntity} with the current user's information or an error message.
     */
    @GetMapping("/me")
    ResponseEntity<?> me(Authentication authentication) {
        try {
            System.out.println(authentication.getPrincipal());
            long userId = Long.parseLong((String) authentication.getPrincipal());
            return ResponseEntity.ok(this.userService.getUserById(userId));
        } catch (ResponseStatusException responseStatusException) {
            logger.error("Error getting user info: {}", responseStatusException.getReason());
            return ResponseEntity.status(responseStatusException.getStatusCode()).body(responseStatusException.getReason());
        }
    }

    /**
     * Updates the current user's information.
     *
     * @param authentication The security context that contains details about the current user.
     * @param newUserInfo The new user information to update.
     * @return A {@code ResponseEntity} with the updated user information or an error message.
     */
    @PutMapping("/me")
    ResponseEntity<?> updateMe(Authentication authentication, @RequestBody User newUserInfo) {
        try {
            logger.info("Updating user info" + newUserInfo.toString());
            long userId = Long.parseLong((String) authentication.getPrincipal());
            return ResponseEntity.ok(this.userService.updateUser(userId, newUserInfo));
        } catch (ResponseStatusException responseStatusException) {
            logger.error("Error updating user info: {}", responseStatusException.getReason());
            return ResponseEntity.status(responseStatusException.getStatusCode()).body(responseStatusException.getReason());
        }
    }
}
