package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code UserDTO} class represents a data transfer object for user information.
 */
public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    /**
     * Gets the user's ID.
     *
     * @return The ID of the user.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the user's first name.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user's username.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the user's email address.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's ID.
     *
     * @param id The new ID for the user.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName The new first name for the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName The new last name for the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the user's username.
     *
     * @param username The new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the user's email address.
     *
     * @param email The new email address for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Provides a string representation of the {@code UserDTO}, including all user details.
     *
     * @return A string representation of this {@code UserDTO}.
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
