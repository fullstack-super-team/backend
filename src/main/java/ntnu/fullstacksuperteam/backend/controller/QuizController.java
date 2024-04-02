package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.CreateQuizDTO;
import ntnu.fullstacksuperteam.backend.service.QuizService;
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

    @GetMapping
    public ResponseEntity<?> getAllQuizzes() {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuizzes());
    }

    @PostMapping()
    public ResponseEntity<?> createQuiz(Authentication authentication, @RequestBody CreateQuizDTO createQuizDTO) {
        Long userId = Long.parseLong((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.createQuiz(userId, createQuizDTO));
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuizById(@PathVariable long quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(quizId));
    }
}
