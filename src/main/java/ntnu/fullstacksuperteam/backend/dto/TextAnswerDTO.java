package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code TextAnswerDTO} class represents a data transfer object for text-based answers.
 */
public class TextAnswerDTO {
    private long id;
    private String text;
    private boolean isCorrect;

    /**
     * Default constructor for {@code TextAnswerDTO}.
     */
    public TextAnswerDTO() {}


    /**
     * Gets the identifier of the text answer.
     *
     * @return The identifier of the text answer.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the text of the answer.
     *
     * @return The text of the answer.
     */
    public String getText() {
        return text;
    }

    /**
     * Checks if the answer is marked as correct.
     *
     * @return {@code true} if the answer is correct, otherwise {@code false}.
     */
    public boolean getIsCorrect() {
        return isCorrect;
    }

    /**
     * Sets the identifier of the text answer.
     *
     * @param id The new identifier for the text answer.
     */
    public void setId(long id) {
        this.id = id;
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
     * Marks the answer as correct or incorrect.
     *
     * @param correct {@code true} to mark the answer as correct, otherwise {@code false}.
     */
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    /**
     * Provides a string representation of the {@code TextAnswerDTO}.
     *
     * @return A string representation of this {@code TextAnswerDTO}.
     */
    @Override
    public String toString() {
        return "TextAnswerDTO{" +
                "text='" + text + '\'' +
                ", correct=" + isCorrect +
                '}';
    }
}
