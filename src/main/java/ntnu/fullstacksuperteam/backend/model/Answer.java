package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


/**
 * The {@code Answer} class is an abstract base class for different types of answers within the quiz system.
*/
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "answer_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "answers")
public abstract class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The question to which this answer belongs.
     * It is annotated with {@code @JsonIgnore} to prevent circular references during serialization.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    /**
     * Default constructor for JPA and other uses.
     */
    public Answer() {}

    /**
     * Gets the unique identifier of the answer.
     *
     * @return The ID of the answer.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the answer.
     *
     * @param id The new ID for the answer.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the question associated with this answer.
     *
     * @return The {@code Question} object associated with this answer.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Sets the question associated with this answer.
     *
     * @param question The {@code Question} to associate with this answer.
     */
    public void setQuestion(Question question) {
        this.question = question;
    }
}
