package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

/**
 * Represents a quiz in the quiz system, including its title, associated questions,
 * category, difficulty level, description, option to randomize question order,
 * author information, and timestamps for creation and last update. This class
 * also manages relationships with the {@code Question} and {@code Score} entities.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String title;

    /**
     * The list of questions associated with this quiz. The relationship is managed
     * with cascade operations to ensure question persistence and removal are
     * handled automatically.
     */
    @OneToMany(mappedBy = "quiz", cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
    private List<Question> questions;
    private Category category;
    private DifficultyLevel difficultyLevel;
    private String description;
    private boolean randomize;

    /**
     * The author of the quiz. Managed as a many-to-one relationship to capture the
     * authorship of the quiz.
     */
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    //private List<User> coAuthors;

    /**
     * The list of scores associated with this quiz. Scores are managed with cascade.
     */
    @OneToMany(mappedBy = "quiz", cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
    private List<Score> scores;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    /**
     * Default constructor for creating a quiz instance.
     */
    public Quiz() {}

    /**
     * Retrieves the unique identifier of the quiz.
     *
     * @return The unique ID of the quiz.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the quiz.
     *
     * @param id The new ID for the quiz.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the quiz.
     *
     * @return The title of the quiz.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the quiz.
     *
     * @param title The new title for the quiz.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the list of questions associated with the quiz.
     *
     * @return The list of questions.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the list of questions for the quiz.
     *
     * @param questions The new list of questions for the quiz.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Retrieves the category of the quiz.
     *
     * @return The category of the quiz.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the quiz.
     *
     * @param category The new category for the quiz.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Retrieves the difficulty level of the quiz.
     *
     * @return The difficulty level of the quiz.
     */
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Sets the difficulty level of the quiz.
     *
     * @param difficultyLevel The new difficulty level for the quiz.
     */
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Retrieves the description of the quiz.
     *
     * @return The description of the quiz.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the quiz.
     *
     * @param description The new description for the quiz.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the flag indicating whether the questions should be randomized.
     *
     * @return True if questions should be randomized, false otherwise.
     */
    public boolean getRandomize() {
        return randomize;
    }

    /**
     * Sets the flag indicating whether questions in the quiz should be randomized.
     *
     * @param randomize The new value for the randomization flag.
     */
    public void setRandomize(boolean randomize) {
        this.randomize = randomize;
    }

    /**
     * Retrieves the author of the quiz.
     *
     * @return The author of the quiz.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the author of the quiz.
     *
     * @param author The new author for the quiz.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Retrieves the creation date and time of the quiz.
     *
     * @return The creation timestamp of the quiz.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date and time of the quiz.
     *
     * @param createdAt The new creation timestamp for the quiz.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retrieves the last updated date and time of the quiz.
     *
     * @return The last updated timestamp of the quiz.
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated date and time of the quiz.
     *
     * @param updatedAt The new last updated timestamp for the quiz.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
