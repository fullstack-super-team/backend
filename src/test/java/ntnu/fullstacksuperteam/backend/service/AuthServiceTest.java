/*
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private TokenService tokenService;

  @InjectMocks
  private AuthService authService;

  private RegisterDTO registerDTO;
  private LoginDTO loginDTO;
  private User user;
  private final String encodedPassword = "encodedPassword";

  @BeforeEach
  void setUp() {
    registerDTO = new RegisterDTO("John", "Doe", "johndoe", "john.doe@example.com", "password");
    loginDTO = new LoginDTO("john.doe@example.com", "password");
    user = new User();
    user.setId(1L);
    user.setPassword(encodedPassword);
  }

  @Test
  void testRegisterSuccess() {
    when(userRepository.findFirstByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail())).thenReturn(null);
    when(userRepository.save(any(User.class))).thenReturn(user);
    when(passwordEncoder.encode(registerDTO.getPassword())).thenReturn(encodedPassword);
    when(tokenService.generateToken(anyLong())).thenReturn("token123");

    Token token = authService.register(registerDTO);

    assertNotNull(token);
    assertEquals("token123", token.getToken());
    verify(userRepository).findFirstByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail());
    verify(userRepository).save(any(User.class));
  }


  @Test
  void testRegisterUserExists() {
    when(userRepository.findFirstByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail())).thenReturn(user);

    assertThrows(ResponseStatusException.class, () -> authService.register(registerDTO));
    verify(userRepository).findFirstByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail());
    verify(userRepository, never()).save(any(User.class));
  }


  @Test
  void testLoginSuccess() {
    when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(user);
    when(passwordEncoder.matches(eq(loginDTO.getPassword()), eq(encodedPassword))).thenReturn(true);
    when(tokenService.generateToken(user.getId())).thenReturn("token123");

    Token token = authService.login(loginDTO);

    assertNotNull(token);
    assertEquals("token123", token.getToken());
    verify(userRepository).findByEmail(eq(loginDTO.getEmail()));
    verify(tokenService).generateToken(user.getId());
  }

  @Test
  void testLoginNotFound() {
    when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(null);

    assertThrows(ResponseStatusException.class, () -> authService.login(loginDTO));
    verify(userRepository).findByEmail(eq(loginDTO.getEmail()));
    verify(tokenService, never()).generateToken(anyLong());
  }

  @Test
  void testLoginWrongCredentials() {
    when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(user);
    when(passwordEncoder.matches(eq(loginDTO.getPassword()), eq(encodedPassword))).thenReturn(false);

    assertThrows(ResponseStatusException.class, () -> authService.login(loginDTO));
    verify(userRepository).findByEmail(eq(loginDTO.getEmail()));
    verify(passwordEncoder).matches(eq(loginDTO.getPassword()), eq(encodedPassword));
    verify(tokenService, never()).generateToken(anyLong());
  }
}
*/
