package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

/**
 * Represents a question within the quiz system.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;

    /**
     * The quiz to which this question belongs. This relationship is managed to avoid JSON circular
     * references through {@code @JsonIgnore}.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private int points;

    private String multimediaUrl;

    /**
     * Represents the type of the question. This field is managed by the discriminator column in the database
     * and is not directly insertable or updatable.
     */
    @Column(name = "question_type", insertable = false, updatable = false)
    @JsonView()
    private String type;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    /**
     * Default constructor for creating an instance of a question.
     */
    public Question() {}

    /**
     * Copy constructor that creates a new instance of a question by duplicating the properties of
     * the given question.
     *
     * @param question The question whose properties are to be copied.
     */
    public Question(Question question) {
        this.id = question.id;
        this.text = question.text;
        this.quiz = question.quiz;
        this.points = question.points;
        this.multimediaUrl = question.multimediaUrl;
        this.type = question.type;
        this.createdAt = question.createdAt;
        this.updatedAt = question.updatedAt;
    }

    /**
     * Returns the ID of the question.
     *
     * @return The ID of the question.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the question.
     *
     * @param id The new ID of the question.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the text content of the question.
     *
     * @return The text content of the question.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of the question.
     *
     * @param text The new text content of the question.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the quiz associated with this question.
     *
     * @return The quiz associated with this question.
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Associates this question with a quiz.
     *
     * @param quiz The quiz to associate with this question.
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * Returns the points value of the question.
     *
     * @return The points value of the question.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the points value of the question.
     *
     * @param points The new points value of the question.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Returns the multimedia URL of the question.
     *
     * @return The multimedia URL of the question.
     */
    public String getMultimediaUrl() {
        return multimediaUrl;
    }

    /**
     * Sets the multimedia URL for the question.
     *
     * @param multimediaUrl The new multimedia URL of the question.
     */
    public void setMultimediaUrl(String multimediaUrl) {
        this.multimediaUrl = multimediaUrl;
    }

    /**
     * Returns the creation timestamp of the question.
     *
     * @return The creation timestamp of the question.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the last updated timestamp of the question.
     *
     * @return The last updated timestamp of the question.
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }
}
