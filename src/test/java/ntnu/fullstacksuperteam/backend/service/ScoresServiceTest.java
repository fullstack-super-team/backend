package ntnu.fullstacksuperteam.backend.service;

import jakarta.persistence.EntityManager;
import ntnu.fullstacksuperteam.backend.model.Quiz;
import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.ScoresRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScoresServiceTest {

  @Mock
  private ScoresRepository scoresRepository;

  @Mock
  private UserService userService;

  @Mock
  private EntityManager entityManager;

  @InjectMocks
  private ScoresService scoresService;

  @BeforeEach
  void setUp() {
    // This method is called before each test execution.
  }

  @Test
  void testGetScoresByUserAndQuizId() {
    long userId = 1L;
    long quizId = 1L;
    Score mockScore = new Score(); // Initialize with mock data as needed
    when(scoresRepository.findAllByUserIdAndQuizIdOrderByDateDesc(userId, quizId))
            .thenReturn(Arrays.asList(mockScore));

    List<Score> scores = scoresService.getScoresByUserAndQuizId(userId, quizId);

    assertEquals(1, scores.size()); // Verify the size of the returned list
    verify(scoresRepository).findAllByUserIdAndQuizIdOrderByDateDesc(userId, quizId);
  }

  @Test
  void testGetScoresByQuizId() {
    long quizId = 1L;
    Score mockScore = new Score(); // Initialize with mock data as needed
    when(scoresRepository.findAllByQuizIdOrderByPointsDescDateDesc(quizId))
            .thenReturn(Arrays.asList(mockScore));

    List<Score> scores = scoresService.getScoresByQuizId(quizId);

    assertEquals(1, scores.size()); // Verify the size of the returned list
    verify(scoresRepository).findAllByQuizIdOrderByPointsDescDateDesc(quizId);
  }

  @Test
  void testSaveScore() {
    long userId = 1L;
    long quizId = 1L;
    User user = new User(); // Initialize with mock data as needed
    Quiz quiz = new Quiz(); // Initialize with mock data as needed
    Score score = new Score(); // Initialize with mock data as needed

    when(userService.getUserById(userId)).thenReturn(user);
    when(entityManager.getReference(Quiz.class, quizId)).thenReturn(quiz);
    when(scoresRepository.save(any(Score.class))).thenReturn(score);

    Score savedScore = scoresService.saveScore(userId, quizId, score);

    assertEquals(score, savedScore); // Verify the returned score is the same as the saved score
    verify(userService).getUserById(userId);
    verify(entityManager).getReference(Quiz.class, quizId);
    verify(scoresRepository).save(score);
  }
}
