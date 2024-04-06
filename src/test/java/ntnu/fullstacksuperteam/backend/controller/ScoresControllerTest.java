package ntnu.fullstacksuperteam.backend.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import ntnu.fullstacksuperteam.backend.model.Score;
import ntnu.fullstacksuperteam.backend.service.ScoresService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ScoresControllerTest {

  private MockMvc mockMvc;

  @Mock
  private ScoresService scoresService;

  @InjectMocks
  private ScoresController scoresController;

  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Mock
  private Authentication authentication;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(scoresController).build();
    // Mock the authentication principal to return a user ID as string
    when(authentication.getPrincipal()).thenReturn("1");
  }

  @Test
  public void getScoresByQuizId() throws Exception {
    long quizId = 1L;
    List<Score> mockScores = new ArrayList<>(); // Populate with mock Score objects as needed

    when(scoresService.getScoresByQuizId(quizId)).thenReturn(mockScores);

    mockMvc.perform(get("/quizzes/{quizId}/scores", quizId))
            .andExpect(status().isOk());

    verify(scoresService).getScoresByQuizId(quizId);
  }

  @Test
  public void getScoresByUserAndQuizId() throws Exception {
    long quizId = 1L;
    List<Score> mockScores = new ArrayList<>(); // Populate with mock Score objects as needed

    when(authentication.getPrincipal()).thenReturn("1"); // Assuming the user ID is 1
    when(scoresService.getScoresByUserAndQuizId(1L, quizId)).thenReturn(mockScores);

    mockMvc.perform(get("/quizzes/{quizId}/scores/me", quizId).principal(authentication))
            .andExpect(status().isOk());

    verify(scoresService).getScoresByUserAndQuizId(1L, quizId);
  }

  @Test
  public void saveScore() throws Exception {
    long quizId = 1L;
    Score mockScore = new Score(); // Populate with a mock Score object as needed
    String scoreJson = objectMapper.writeValueAsString(mockScore);

    when(authentication.getPrincipal()).thenReturn("1"); // Assuming the user ID is 1
    when(scoresService.saveScore(eq(1L), eq(quizId), any(Score.class))).thenReturn(mockScore);

    mockMvc.perform(post("/quizzes/{quizId}/scores", quizId)
                    .principal(authentication)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(scoreJson))
            .andExpect(status().isCreated());

    // Using any(Score.class) matcher for the score parameter
    verify(scoresService).saveScore(eq(1L), eq(quizId), any(Score.class));
  }

}
