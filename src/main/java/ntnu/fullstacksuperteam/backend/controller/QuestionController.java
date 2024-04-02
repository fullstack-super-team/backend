package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.CreateQuestionDTO;
import ntnu.fullstacksuperteam.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes/{quizId}/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<?> getQuestionsByQuizId(@PathVariable long quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsByQuizId(quizId));
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@PathVariable long quizId, @RequestBody CreateQuestionDTO createQuestionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.createQuestion(quizId, createQuestionDTO));
    }
}
