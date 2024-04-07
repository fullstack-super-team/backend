package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.service.ScoresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * The {@code ScoresController} class is responsible for managing score-related operations for quizzes.
 * */
@RestController
@RequestMapping("/quizzes/{quizId}/scores")
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    private final Logger logger = LoggerFactory.getLogger(ScoresController.class);

    /**
     * Retrieves the top ten recent scores for a specified quiz.
     *
     * @param quizId The ID of the quiz for which to retrieve scores.
     * @return A {@code ResponseEntity} with the list of top ten scores or an error message.
     */
    @GetMapping()
    public ResponseEntity<?> getScoresByQuizId(@PathVariable long quizId) {
        try {
            List<Score> scores = this.scoresService.getScoresByQuizId(quizId);
            int endIndex = Math.min(scores.size(), 10);
            List<Score> topTenRecentScores = scores.subList(0, endIndex);
            return ResponseEntity.status(HttpStatus.OK).body(topTenRecentScores);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /**
     * Retrieves up to five recent scores for a specific user and quiz.
     *
     * @param authentication The authentication token containing the user's ID.
     * @param quizId The ID of the quiz for which to retrieve scores.
     * @return A {@code ResponseEntity} with the list of recent scores for the user or an error message.
     */
    @GetMapping("/me")
    public ResponseEntity<?> getScoresByUserAndQuizId(Authentication authentication, @PathVariable long quizId) {
        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            List<Score> scores = this.scoresService.getScoresByUserAndQuizId(userId, quizId);
            int endIndex = Math.min(scores.size(), 5);
            List<Score> recentFiveScores = scores.subList(0, endIndex);
            return ResponseEntity.status(HttpStatus.OK).body(recentFiveScores);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    /**
     * Submits a new score for a user and quiz.
     *
     * @param authentication The authentication token containing the user's ID.
     * @param quizId The ID of the quiz for which the score is submitted.
     * @param score The score object to be saved.
     * @return A {@code ResponseEntity} with the saved score or an error message.
     */
    @PostMapping
    public ResponseEntity<?> saveScore(Authentication authentication, @PathVariable long quizId, @RequestBody Score score) {
        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            return ResponseEntity.status(HttpStatus.CREATED).body(scoresService.saveScore(userId, quizId, score));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
