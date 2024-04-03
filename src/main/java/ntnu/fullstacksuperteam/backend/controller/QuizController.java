package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.CreateQuizDTO;
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
    public ResponseEntity<?> createQuiz(Authentication authentication, @RequestBody CreateQuizDTO createQuizDTO) {
        long userId = Long.parseLong((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.createQuiz(userId, createQuizDTO));
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuizById(@PathVariable long quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(quizId));
    }
}
