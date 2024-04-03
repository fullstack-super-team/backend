package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.CreateQuestionDTO;
import ntnu.fullstacksuperteam.backend.dto.SubmitAnswerDTO;
import ntnu.fullstacksuperteam.backend.model.Question;
import ntnu.fullstacksuperteam.backend.service.QuestionService;
import org.h2.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes/{quizId}/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @GetMapping
    public ResponseEntity<?> getQuestionsByQuizId(@PathVariable long quizId) {
        try {
            List<Question> questions = questionService.getQuestionsByQuizId(quizId);
            logger.info(questions.toString());
            return ResponseEntity.status(HttpStatus.OK).body(questions);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@PathVariable long quizId, @RequestBody CreateQuestionDTO createQuestionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.createQuestion(quizId, createQuestionDTO));
    }

    @PostMapping("/{questionId}/submit-answer")
    public ResponseEntity<?> submitAnswer(@PathVariable long questionId, @RequestBody SubmitAnswerDTO submitAnswerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.submitAnswer(questionId, submitAnswerDTO));
    }
}
