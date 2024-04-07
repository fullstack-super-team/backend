package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code TrueOrFalseAnswerDTO} class represents a data transfer object for answers to true or false questions.
 */
public class TrueOrFalseAnswerDTO {
    private long id;
    private String text;
    private boolean isCorrect;

    /**
     * Default constructor for {@code TrueOrFalseAnswerDTO}.
     */
    public TrueOrFalseAnswerDTO() {}

    /**
     * Gets the identifier of the true or false answer.
     *
     * @return The identifier of the answer.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the text of the answer. While this may simply be "true" or "false",
     * it allows for additional clarification or context to be provided in the answer text.
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
     * Sets the identifier of the true or false answer.
     *
     * @param id The new identifier for the answer.
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
}
