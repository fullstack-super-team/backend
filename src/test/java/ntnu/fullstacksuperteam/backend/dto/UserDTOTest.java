package ntnu.fullstacksuperteam.backend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {
  private UserDTO userDTO;

  @BeforeEach
  public void setUp() {
    userDTO = new UserDTO();
    // Assuming there are setter methods to initialize these fields, as they are not shown in the class provided.
    userDTO.setId(1L);
    userDTO.setFirstName("John");
    userDTO.setLastName("Doe");
    userDTO.setUsername("johndoe");
    userDTO.setEmail("john.doe@example.com");
  }

  @Test
  public void testGetIdReturnsCorrectId() {
    assertEquals(1L, userDTO.getId(), "getId() should return the correct id.");
  }

  @Test
  public void testGetFirstNameReturnsCorrectName() {
    assertEquals("John", userDTO.getFirstName(), "getFirstName() should return the correct first name.");
  }

  @Test
  public void testGetLastNameReturnsCorrectName() {
    assertEquals("Doe", userDTO.getLastName(), "getLastName() should return the correct last name.");
  }

  @Test
  public void testGetUsernameReturnsCorrectUsername() {
    assertEquals("johndoe", userDTO.getUsername(), "getUsername() should return the correct username.");
  }

  @Test
  public void testGetEmailReturnsCorrectEmail() {
    assertEquals("john.doe@example.com", userDTO.getEmail(), "getEmail() should return the correct email.");
  }

  @Test
  public void testToStringReturnsCorrectFormat() {
    String expected = "UserDTO{id=1, firstName='John', lastName='Doe', username='johndoe', email='john.doe@example.com'}";
    assertEquals(expected, userDTO.toString(), "toString() should return the correct string representation.");
  }
}
