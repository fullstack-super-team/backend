package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Represents a text-based answer within the quiz system. This class extends the generic {@link Answer}
 * entity to specifically handle answers where the response is given as text.
 */
@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer {

    private String text;

    private boolean isCorrect;

    /**
     * Constructs a new, empty TextAnswer instance. This is the default constructor required by JPA.
     */
    public TextAnswer() {}

    /**
     * Retrieves the text of the answer.
     *
     * @return The answer text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the answer.
     *
     * @param text The new text for the answer.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Checks if the answer is marked as correct.
     *
     * @return True if the answer is correct, false otherwise.
     */
    public boolean isIsCorrect() {
        return isCorrect;
    }

    /**
     * Marks the answer as correct or incorrect.
     *
     * @param correct True to mark the answer as correct, false to mark it as incorrect.
     */
    public void setIsCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    /**
     * Generates a string representation of the TextAnswer instance.
     *
     * @return A string representation of the TextAnswer instance.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextAnswer{");
        stringBuilder.append("text=").append(this.text);
        stringBuilder.append(", ");
        stringBuilder.append("correct=").append(this.isCorrect);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
