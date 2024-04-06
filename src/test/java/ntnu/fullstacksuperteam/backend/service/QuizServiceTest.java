package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

  @Mock
  private QuizRepository quizRepository;

  @Mock
  private UserService userService;

  @Mock
  private QuestionService questionService;

  @InjectMocks
  private QuizService quizService;

  @BeforeEach
  void setUp() {
  }

  @Test
  void testGetAllQuizzes() {
    Quiz quiz = new Quiz();
    when(quizRepository.findAll()).thenReturn(Arrays.asList(quiz));

    List<Quiz> quizzes = quizService.getAllQuizzes();

    assertEquals(1, quizzes.size());
    verify(quizRepository).findAll();
  }

  @Test
  void testSearchQuizzes() {
    String query = "Sample";
    Quiz quiz = new Quiz();
    when(quizRepository.findAllByTitleContaining(query)).thenReturn(Arrays.asList(quiz));

    List<Quiz> quizzes = quizService.searchQuizzes(query);

    assertEquals(1, quizzes.size());
    verify(quizRepository).findAllByTitleContaining(query);
  }

  @Test
  void testGetMyQuizzes() {
    long userId = 1L;
    User user = new User();
    when(userService.getUserById(userId)).thenReturn(user);

    Quiz quiz = new Quiz();
    when(quizRepository.findAllByAuthor(user)).thenReturn(Arrays.asList(quiz));

    List<Quiz> quizzes = quizService.getMyQuizzes(userId);

    assertEquals(1, quizzes.size());
    verify(userService).getUserById(userId);
    verify(quizRepository).findAllByAuthor(user);
  }

  @Test
  void testGetQuizById() {
    long quizId = 1L;
    Quiz quiz = new Quiz();
    when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));

    Quiz foundQuiz = quizService.getQuizById(quizId);

    assertEquals(quiz, foundQuiz);
    verify(quizRepository, times(2)).findById(quizId);
  }

  @Test
  void testGetQuizById_NotFound() {
    long quizId = 1L;
    when(quizRepository.findById(quizId)).thenReturn(Optional.empty());

    assertThrows(ResponseStatusException.class, () -> quizService.getQuizById(quizId));
    verify(quizRepository).findById(quizId);
  }


}
