package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.QuestionDTO;
import ntnu.fullstacksuperteam.backend.dto.SubmitAnswerDTO;
import ntnu.fullstacksuperteam.backend.model.Question;
import ntnu.fullstacksuperteam.backend.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The {@code QuestionController} class manages the CRUD operations for questions within quizzes.
 */
@RestController
@RequestMapping("/quizzes/{quizId}/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    /**
     * Retrieves all questions associated with a given quiz.
     *
     * @param quizId The ID of the quiz for which to retrieve questions.
     * @return A {@code ResponseEntity} with the list of questions or an error message in case of failure.
     */
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

    /**
     * Creates a new question for a specified quiz.
     *
     * @param quizId The ID of the quiz for which to create a new question.
     * @param questionDTO The data transfer object containing the question's data.
     * @return A {@code ResponseEntity} with the created question or an error message in case of failure.
     */
    @PostMapping
    public ResponseEntity<?> createQuestion(@PathVariable long quizId, @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.createQuestion(quizId, questionDTO));
    }

    /**
     * Submits an answer for a specific question.
     *
     * @param questionId The ID of the question to which the answer is submitted.
     * @param submitAnswerDTO The data transfer object containing the submitted answer's data.
     * @return A {@code ResponseEntity} with the result of the answer submission or an error message in case of failure.
     */
    @PostMapping("/{questionId}/submit-answer")
    public ResponseEntity<?> submitAnswer(@PathVariable long questionId, @RequestBody SubmitAnswerDTO submitAnswerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.submitAnswer(questionId, submitAnswerDTO));
    }
}
