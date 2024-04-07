package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

/**
 * The {@code User} class represents a user entity within the application.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    /**
     * The password of the user. This field is marked with {@code @JsonIgnore} to
     * ensure it is not serialized into JSON when entities are converted for API responses.
     */
    @JsonIgnore
    private String password;

    /**
     * A list of {@code Score} entities associated with the user.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Score> scoreList;

    /**
     * The timestamp when the user entity was created.
     */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    /**
     * The timestamp of the last update made to the user entity.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    /**
     * Default constructor for JPA and general usage.
     */
    public User() {}

    /**
     * Retrieves the unique identifier for the user.
     *
     * @return The unique ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the user's password.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the creation timestamp of the user entity.
     *
     * @return The {@code Date} the user was created.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Retrieves the last update timestamp of the user entity.
     *
     * @return The {@code Date} the user was last updated.
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Retrieves the list of scores associated with the user.
     *
     * @return A {@code List} of {@code Score} objects associated with the user.
     */
    public List<Score> getScoreList() {
        return scoreList;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param id The new ID to set for the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The new first name to set for the user.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The new last name to set for the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username to set for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The new email address to set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user's password.
     *
     * @param password The new password to set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the list of scores for the user.
     *
     * @param scoreList A {@code List} of {@code Score} objects to be associated with the user.
     */
    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    /**
     * Provides a string representation of the user entity.
     *
     * @return A string representation of the user, including id, first name, last name, username, and email.
     */
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
