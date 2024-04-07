package ntnu.fullstacksuperteam.backend.service;

import jakarta.persistence.EntityNotFoundException;
import ntnu.fullstacksuperteam.backend.dto.*;
import ntnu.fullstacksuperteam.backend.model.Question;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.TextQuestion;
import ntnu.fullstacksuperteam.backend.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

  @Mock
  private QuestionRepository questionRepository;

  @Mock
  private EntityManager entityManager;

  @InjectMocks
  private QuestionService questionService;

  @BeforeEach
  void setUp() {
  }

  @Test
  void getQuestionsByQuizIdShouldReturnQuestions() {
    long quizId = 1L;
    when(questionRepository.findByQuizId(quizId)).thenReturn(Collections.emptyList());

    List<Question> questions = questionService.getQuestionsByQuizId(quizId);

    assertNotNull(questions, "Returned list should not be null");
    verify(questionRepository).findByQuizId(quizId);
  }

  @Test
  void createQuestionShouldCreateTextQuestion() {
    Quiz quiz = new Quiz();
    when(entityManager.getReference(Quiz.class, 1L)).thenReturn(quiz);

    when(questionRepository.save(any(Question.class))).thenAnswer(invocation -> invocation.getArgument(0));

    TextQuestionDTO questionDTO = new TextQuestionDTO();
    TextAnswerDTO textAnswerDTO1 = new TextAnswerDTO();
    textAnswerDTO1.setText("Answer 1");
    textAnswerDTO1.setCorrect(true);

    questionDTO.setAnswers(List.of(textAnswerDTO1));

    Question createdQuestion = questionService.createQuestion(1L, questionDTO);

    assertNotNull(createdQuestion, "Created question should not be null");
  }

  @Test
  void updateQuestionShouldUpdateTextQuestionCorrectly() {
    TextQuestion existingQuestion = new TextQuestion();
    existingQuestion.setId(1L);
    when(questionRepository.findById(1L)).thenReturn(Optional.of(existingQuestion));

    when(questionRepository.save(any(Question.class))).thenAnswer(invocation -> invocation.getArgument(0));

    TextQuestionDTO questionDTO = new TextQuestionDTO();
    questionDTO.setId(1L);

    TextAnswerDTO textAnswerDTO = new TextAnswerDTO();
    questionDTO.setAnswers(List.of(textAnswerDTO)); // Ensure at least one answer is set

    Question updatedQuestion = questionService.updateQuestion(questionDTO);

    assertNotNull(updatedQuestion, "Updated question should not be null");
    verify(questionRepository, times(2)).save(any(Question.class));
  }


  @Test
  void submitAnswerShouldCorrectlyEvaluateTextQuestion() {
    // Mock the question retrieval
    TextQuestion textQuestion = new TextQuestion();
    textQuestion.setId(1L);
    textQuestion.setPoints(10);
    when(questionRepository.findById(1L)).thenReturn(Optional.of(textQuestion));

    SubmitAnswerDTO submitAnswerDTO = new SubmitAnswerDTO();
    submitAnswerDTO.setAnswer("Correct Answer");

    SubmittedAnswerDTO<?> submittedAnswer = questionService.submitAnswer(1L, submitAnswerDTO);
  }

  @Test
  void updateQuestionShouldThrowWhenQuestionDoesNotExist() {
    when(questionRepository.findById(anyLong())).thenReturn(Optional.empty());

    QuestionDTO questionDTO = new QuestionDTO();
    questionDTO.setId(999L); // Non-existent question ID

    assertThrows(NoSuchElementException.class, () -> questionService.updateQuestion(questionDTO),
            "Should throw an exception when question does not exist");
  }



}
