package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import ntnu.fullstacksuperteam.backend.dto.LoginDTO;
import ntnu.fullstacksuperteam.backend.model.Token;
import ntnu.fullstacksuperteam.backend.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    Token register(@RequestBody RegisterDTO registerDTO) {
        logger.info("Register: " + registerDTO);
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    Token login(@RequestBody LoginDTO loginDTO) {
        logger.info("Login with credentials:" + loginDTO);
        return authService.login(loginDTO);
    }
}
