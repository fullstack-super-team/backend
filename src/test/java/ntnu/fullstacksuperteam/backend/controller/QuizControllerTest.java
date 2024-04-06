package ntnu.fullstacksuperteam.backend.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ntnu.fullstacksuperteam.backend.dto.QuizDTO;
import ntnu.fullstacksuperteam.backend.service.QuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuizControllerTest {

  private MockMvc mockMvc;

  @Mock
  private QuizService quizService;

  @InjectMocks
  private QuizController quizController;

  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Mock
  private Authentication authentication;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(quizController).build();

    // Setup a mock authentication object
    when(authentication.getPrincipal()).thenReturn("1");
    User testUser = new User("user", "password", AuthorityUtils.createAuthorityList("ROLE_USER"));
    when(authentication.getPrincipal()).thenReturn(testUser.getUsername());
  }

  @Test
  void getAllQuizzes() throws Exception {
    mockMvc.perform(get("/quizzes"))
            .andExpect(status().isOk());
    verify(quizService).getAllQuizzes();
  }

  @Test
  void searchQuizzes() throws Exception {
    String query = "test";
    mockMvc.perform(get("/quizzes/search").param("query", query))
            .andExpect(status().isOk());
    verify(quizService).searchQuizzes(query);
  }

  @Test
  void getMyQuizzes() throws Exception {
    // Simulate the user ID being correctly parsed from the Authentication object
    when(authentication.getPrincipal()).thenReturn("1"); // Return a string that can be parsed to a long

    mockMvc.perform(get("/quizzes/my").principal(authentication))
            .andExpect(status().isOk());
    verify(quizService).getMyQuizzes(1L);
  }

  @Test
  void createQuiz() throws Exception {
    QuizDTO quizDTO = new QuizDTO(); // Populate this as needed
    String quizDTOJson = objectMapper.writeValueAsString(quizDTO);

    // Simulate the user ID being correctly parsed from the Authentication object
    when(authentication.getPrincipal()).thenReturn("1"); // Return a string that can be parsed to a long

    mockMvc.perform(post("/quizzes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(quizDTOJson)
                    .principal(authentication))
            .andExpect(status().isCreated());
    verify(quizService).createQuiz(eq(1L), any(QuizDTO.class));
  }


  @Test
  void updateQuiz() throws Exception {
    long quizId = 1L;
    QuizDTO quizDTO = new QuizDTO();
    String quizDTOJson = objectMapper.writeValueAsString(quizDTO);

    when(authentication.getPrincipal()).thenReturn("1");

    mockMvc.perform(put("/quizzes/{quizId}", quizId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(quizDTOJson)
                    .principal(authentication))
            .andExpect(status().isOk());

    verify(quizService).updateQuiz(eq(1L), eq(quizId), any(QuizDTO.class));
  }


  @Test
  void getQuizById() throws Exception {
    long quizId = 1L;
    mockMvc.perform(get("/quizzes/{quizId}", quizId))
            .andExpect(status().isOk());
    verify(quizService).getQuizById(quizId);
  }
}
