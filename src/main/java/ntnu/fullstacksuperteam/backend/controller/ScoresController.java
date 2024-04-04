package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.service.ScoresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quizzes/{quizId}/scores")
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    private final Logger logger = LoggerFactory.getLogger(ScoresController.class);

    @GetMapping()
    public ResponseEntity<?> getScoresByQuizId(@PathVariable long quizId) {
        try {
            List<Score> scores = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.OK).body(scores);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getScoresByUserAndQuizId(Authentication authentication, @PathVariable long quizId) {
        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            List<Score> scores = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.OK).body(scores);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
