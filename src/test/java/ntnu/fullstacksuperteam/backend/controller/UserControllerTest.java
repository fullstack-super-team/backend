package ntnu.fullstacksuperteam.backend.controller;

import ntnu.fullstacksuperteam.backend.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import ntnu.fullstacksuperteam.backend.service.UserService;
import ntnu.fullstacksuperteam.backend.dto.UserDTO;
import org.springframework.web.server.ResponseStatusException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

  @Mock
  private UserService userService;

  @Mock
  private Authentication authentication;

  @InjectMocks
  private UserController userController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testMe_Success() {
    // Arrange
    long userId = 1L;
    User mockUserDTO = new User();
    mockUserDTO.setId(userId);
    when(authentication.getPrincipal()).thenReturn(String.valueOf(userId));
    when(userService.getUserById(userId)).thenReturn(mockUserDTO);

    // Act
    ResponseEntity<?> response = userController.me(authentication);

    // Assert
    assertEquals(response.getStatusCodeValue(), 200);
    assertEquals(response.getBody(), mockUserDTO);
    verify(userService).getUserById(userId);
  }

  @Test
  void testMe_ResponseStatusException() {
    // Arrange
    long userId = 999L; // A user ID that doesn't exist or causes the service to throw an exception
    when(authentication.getPrincipal()).thenReturn(String.valueOf(userId));
    when(userService.getUserById(userId)).thenThrow(new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "User not found"));

    // Act
    ResponseEntity<?> response = userController.me(authentication);

    // Assert
    assertEquals(404, response.getStatusCodeValue());
    assertEquals("User not found", response.getBody());
    verify(userService).getUserById(userId);
  }

}
