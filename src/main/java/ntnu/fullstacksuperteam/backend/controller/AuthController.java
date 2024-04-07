package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.ErrorResponse;
import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import ntnu.fullstacksuperteam.backend.dto.LoginDTO;
import ntnu.fullstacksuperteam.backend.model.Token;
import ntnu.fullstacksuperteam.backend.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * The {@code AuthController} class handles authentication requests, including registration and login functionalities.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * Registers a new user in the system.
     *
     * @param registerDTO The data transfer object containing user registration information.
     * @return A {@code ResponseEntity} with a status of {@code CREATED} if registration is successful, or an appropriate error response otherwise.
     */
    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        logger.info("Register: {}", registerDTO);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerDTO));
        } catch (ResponseStatusException responseStatusException) {
            logger.error("Error registering user: {}", responseStatusException.getReason());
            ErrorResponse errorResponse = new ErrorResponse(responseStatusException.getReason());
            return ResponseEntity.status(responseStatusException.getStatusCode()).body(errorResponse);
        }
    }

    /**
     * Authenticates a user and logs them into the system.
     *
     * @param loginDTO The data transfer object containing user login credentials.
     * @return A {@code ResponseEntity} with a status of {@code OK} if login is successful, or an appropriate error response otherwise.
     */
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        logger.info("Login {}", loginDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginDTO));
        } catch (ResponseStatusException responseStatusException) {
            logger.error("Error logging in user: {}", responseStatusException.getReason());
            ErrorResponse errorResponse = new ErrorResponse(responseStatusException.getReason());
            return ResponseEntity.status(responseStatusException.getStatusCode()).body(errorResponse);
        }
    }
}
