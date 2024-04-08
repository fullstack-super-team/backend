package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Represents a score achieved by a user on a quiz. This entity links together the user who took the quiz,
 * the quiz taken, the points scored, and the date when the score was recorded. It's part of the system's
 * mechanism to track and manage users' performances across different quizzes.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The user who achieved this score. The relationship is eagerly fetched, meaning the user information
     * is loaded together with the score.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private int points;

    /**
     * The quiz on which this score was achieved. This field is marked to be ignored by JSON serialization
     * to prevent circular reference issues.
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    /**
     * The date when this score was recorded, automatically set to the current date and time when the score
     * is created.
     */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;

    /**
     * Default constructor for creating a Score instance.
     */
    public Score() {}

    /**
     * Retrieves the unique identifier of the score.
     *
     * @return The ID of the score.
     */
    public long getId() {
        return id;
    }

    /**
     * Retrieves the user who achieved the score.
     *
     * @return The user associated with this score.
     */
    public User getUser() {
        return user;
    }

    /**
     * Retrieves the points scored in the quiz.
     *
     * @return The points scored.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Retrieves the quiz on which the score was achieved.
     *
     * @return The quiz associated with this score.
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Retrieves the date when the score was recorded.
     *
     * @return The date of recording the score.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the user who achieved the score.
     *
     * @param user The user who achieved the score.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the points scored in the quiz.
     *
     * @param points The points scored.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Sets the quiz on which the score was achieved.
     *
     * @param quiz The quiz associated with the score.
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
