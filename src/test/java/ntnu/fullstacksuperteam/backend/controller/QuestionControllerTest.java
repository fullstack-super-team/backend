package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.dto.QuestionDTO;
import ntnu.fullstacksuperteam.backend.dto.SubmitAnswerDTO;
import ntnu.fullstacksuperteam.backend.dto.SubmittedAnswerDTO;
import ntnu.fullstacksuperteam.backend.model.Question;
import ntnu.fullstacksuperteam.backend.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class QuestionControllerTest {

  @Mock
  private QuestionService questionService;

  @InjectMocks
  private QuestionController questionController;

  private QuestionDTO questionDTO;
  private SubmitAnswerDTO submitAnswerDTO;
  private List<Question> questions;

  @BeforeEach
  void setUp() {
    questionDTO = new QuestionDTO(); // Initialize with test data as needed
    submitAnswerDTO = new SubmitAnswerDTO(); // Initialize with test data as needed
    questions = Arrays.asList(new Question(), new Question()); // Initialize with test data as needed
  }

  @Test
  void testGetQuestionsByQuizId() {
    long quizId = 1L;
    when(questionService.getQuestionsByQuizId(quizId)).thenReturn(questions);

    ResponseEntity<?> response = questionController.getQuestionsByQuizId(quizId);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(questions, response.getBody());
    verify(questionService).getQuestionsByQuizId(quizId);
  }

  @Test
  void testCreateQuestion() {
    long quizId = 1L;
    Question question = new Question(); // Initialize with test data as needed
    when(questionService.createQuestion(eq(quizId), any(QuestionDTO.class))).thenReturn(question);

    ResponseEntity<?> response = questionController.createQuestion(quizId, questionDTO);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(question, response.getBody());
    verify(questionService).createQuestion(quizId, questionDTO);
  }

/*  @Test
  void testSubmitAnswer() {
    long questionId = 1L;
    SubmittedAnswerDTO<String> answerResult = new SubmittedAnswerDTO<>("", "", 0);
    when(questionService.submitAnswer(eq(questionId), any(SubmitAnswerDTO.class))).thenReturn(answerResult);

    ResponseEntity<?> response = questionController.submitAnswer(questionId, submitAnswerDTO);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(answerResult, response.getBody());
    verify(questionService).submitAnswer(questionId, submitAnswerDTO);
  }*/
}
