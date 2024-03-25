package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.UserDTO;
import ntnu.fullstacksuperteam.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/me")
    ResponseEntity<?> me(Authentication authentication) {
        try {
            System.out.println(authentication.getPrincipal());
            return ResponseEntity.ok(this.userService.me(Long.parseLong((String) authentication.getPrincipal())));
        } catch (ResponseStatusException responseStatusException) {
            logger.error("Error getting user info: {}", responseStatusException.getReason());
            return ResponseEntity.status(responseStatusException.getStatusCode()).body(responseStatusException.getReason());
        }
    }
}
