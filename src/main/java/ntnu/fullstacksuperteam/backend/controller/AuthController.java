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

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

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
