package ntnu.fullstacksuperteam.backend.dto;


/**
 * The {@code LoginDTO} class represents a data transfer object for user login information.
 */
public class LoginDTO {
    private final String email;
    private final String password;

    /**
     * Constructs a new {@code LoginDTO} instance with the user's email and password.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     */
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Provides a string representation of the {@code LoginDTO}.
     *
     * @return A {@code String} that concatenates the user's email and password.
     */
    public String toString() {
        return getEmail() + getPassword();
    }
}
