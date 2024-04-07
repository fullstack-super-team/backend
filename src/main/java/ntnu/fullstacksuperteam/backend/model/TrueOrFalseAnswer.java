package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * The {@code TrueOrFalseAnswer} class represents a specific type of answer
 * for questions that are based on a true or false response. It extends the
 * {@code Answer} class, inheriting its basic properties and functionalities.
 */
@Entity
@DiscriminatorValue("TRUE_OR_FALSE")
public class TrueOrFalseAnswer extends Answer {
    private String text;
    private boolean isCorrect;

    /**
     * Default constructor for JPA and general purpose use.
     */
    public TrueOrFalseAnswer() {}

    /**
     * Retrieves the text of this answer.
     *
     * @return The text of the answer.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text for this answer.
     *
     * @param text The text to be set for this answer.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Checks if this answer is marked as correct.
     *
     * @return {@code true} if the answer is correct, otherwise {@code false}.
     */
    public boolean isIsCorrect() {
        return isCorrect;
    }

    /**
     * Marks this answer as correct or incorrect.
     *
     * @param correct {@code true} to mark this answer as correct, {@code false} otherwise.
     */
    public void setIsCorrect(boolean correct) {
        this.isCorrect = correct;
    }
}
