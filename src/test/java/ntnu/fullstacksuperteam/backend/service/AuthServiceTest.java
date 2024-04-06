package ntnu.fullstacksuperteam.backend.service;

import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import ntnu.fullstacksuperteam.backend.dto.LoginDTO;
import ntnu.fullstacksuperteam.backend.model.Token;
import ntnu.fullstacksuperteam.backend.model.User;
import ntnu.fullstacksuperteam.backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private TokenService tokenService;

  @InjectMocks
  private AuthService authService;

  private RegisterDTO registerDTO;
  private LoginDTO loginDTO;
  private User user;

  @BeforeEach
  void setUp() {
    // Setup DTOs
    registerDTO = new RegisterDTO("John", "Doe", "johndoe", "john.doe@example.com", "password");
    loginDTO = new LoginDTO("john.doe@example.com", "password");

    // Setup a mock user
    user = new User();
    user.setId(1L); // Simulate database ID assignment
    user.setPassword("password");
  }

  @Test
  void testRegisterSuccess() {
    when(userRepository.findByEmail(anyString())).thenReturn(null);
    when(userRepository.save(any(User.class))).thenReturn(user);
    when(tokenService.generateToken(anyLong())).thenReturn("token123");

    Token token = authService.register(registerDTO);
    assertNotNull(token);
    assertEquals("token123", token.getToken());

    verify(userRepository, times(1)).save(any(User.class));
    verify(tokenService, times(1)).generateToken(anyLong());
  }

  @Test
  void testRegisterUserExists() {
    when(userRepository.findByEmail(anyString())).thenReturn(user);

    assertThrows(ResponseStatusException.class, () -> authService.register(registerDTO));
  }

  @Test
  void testLoginSuccess() {
    when(userRepository.findByEmail(anyString())).thenReturn(user);
    when(tokenService.generateToken(anyLong())).thenReturn("token123");

    Token token = authService.login(loginDTO);
    assertNotNull(token);
    assertEquals("token123", token.getToken());

    verify(userRepository, times(1)).findByEmail(anyString());
    verify(tokenService, times(1)).generateToken(anyLong());
  }

  @Test
  void testLoginNotFound() {
    when(userRepository.findByEmail(anyString())).thenReturn(null);

    assertThrows(ResponseStatusException.class, () -> authService.login(loginDTO));
  }

  @Test
  void testLoginWrongCredentials() {
    when(userRepository.findByEmail(anyString())).thenReturn(user);

    user.setPassword("wrongPassword");
    assertThrows(ResponseStatusException.class, () -> authService.login(loginDTO));
  }
}
