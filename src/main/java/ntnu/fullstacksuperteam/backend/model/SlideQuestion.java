package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

/**
 * Extends the {@link Question} class to specifically handle questions that are answered
 * using a slider to select a value within a defined range. This class is associated with
 * the {@link SlideAnswer} entity, which holds the range and correct value for the question.
 * It utilizes single-table inheritance to differentiate itself within the broader {@code Question}
 * hierarchy in the database.
 */
@Entity
@DiscriminatorValue("SLIDE")
public class SlideQuestion extends Question {

    /**
     * The answer configuration for this slide question, including the valid range of values,
     * the correct answer value, and any step size for the slider. Managed via a one-to-one relationship
     * with cascade operations enabled to ensure lifecycle synchronization between the question
     * and its answer.
     */
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private SlideAnswer answer;

    /**
     * Constructs a new SlideQuestion instance without initializing its fields.
     */
    public SlideQuestion() {}

    /**
     * Constructs a new SlideQuestion instance by copying properties from a given question.
     *
     * @param question The question to copy properties from.
     */
    public SlideQuestion(Question question) {
        super(question);
    }

    /**
     * Retrieves the slide answer associated with this question.
     *
     * @return The slide answer for this question.
     */
    public SlideAnswer getAnswer() {
        return answer;
    }

    /**
     * Sets the slide answer for this question, defining the range of acceptable answers
     * and the correct value within that range.
     *
     * @param answer The slide answer to associate with this question.
     */
    public void setAnswer(SlideAnswer answer) {
        this.answer = answer;
    }
}
