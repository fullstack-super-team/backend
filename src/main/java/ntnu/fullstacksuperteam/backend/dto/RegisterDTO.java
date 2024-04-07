package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code RegisterDTO} class represents a data transfer object for user registration.
 */
public class RegisterDTO {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String password;

    /**
     * Constructs a new {@code RegisterDTO} with the specified user details.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param username The username chosen by the user.
     * @param email The email address of the user.
     * @param password The password chosen by the user.
     */
    public RegisterDTO(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }
}
