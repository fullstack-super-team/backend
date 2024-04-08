package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * The {@code Feedback} class represents feedback provided by users.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The user who provided the feedback. It is linked to the {@code User} entity.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;

    /**
     * The timestamp when the feedback was created. It is automatically set when the feedback is persisted.
     */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    /**
     * Default constructor for JPA and other uses.
     */
    public Feedback() {}

    /**
     * Gets the ID of the feedback.
     *
     * @return the feedback ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the user who submitted the feedback.
     *
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the comment of the feedback.
     *
     * @return the feedback comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Gets the creation timestamp of the feedback.
     *
     * @return the creation timestamp.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the ID of the feedback.
     *
     * @param id the new feedback ID.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the user who submitted the feedback.
     *
     * @param user the user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the comment of the feedback.
     *
     * @param comment the new feedback comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Provides a string representation of this feedback entity, including its ID, user, and comment.
     *
     * @return a string representation of the feedback.
     */
    public String toString() {
        return "Feedback: id=" + id + ", user=" + user + ", comment=" + comment;
    }
}
