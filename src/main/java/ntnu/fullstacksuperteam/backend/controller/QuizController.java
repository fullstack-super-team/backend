package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.service.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    private final Logger logger = LoggerFactory.getLogger(QuizController.class);

    @GetMapping
    public ResponseEntity<?> getAllQuizzes() {
        logger.info("Getting all quizzes");
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuizzes());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchQuizzes(@RequestParam String query, @RequestParam(required = false) String category, @RequestBody(required = false) String difficultyLevel) {
        logger.info("Searching for quizzes with query: " + query + category + difficultyLevel);
        return ResponseEntity.status(HttpStatus.OK).body(quizService.searchQuizzes(query));
    }

    @GetMapping("/my")
    public ResponseEntity<?> getMyQuizzes(Authentication authentication) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        logger.info("Getting all quizzes");
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getMyQuizzes(userId));
    }

    @PostMapping()
    public ResponseEntity<?> createQuiz(Authentication authentication, @RequestBody QuizDTO quizDTO) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.createQuiz(userId, quizDTO));
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<?> updateQuiz(Authentication authentication, @PathVariable long quizId, @RequestBody QuizDTO quizDTO) {
        logger.info("Updating quiz with id: " + quizId);

        try {
            long userId = Long.parseLong((String) authentication.getPrincipal());
            return ResponseEntity.status(HttpStatus.OK).body(quizService.updateQuiz(userId, quizId, quizDTO));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuizById(@PathVariable long quizId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(quizId));
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
