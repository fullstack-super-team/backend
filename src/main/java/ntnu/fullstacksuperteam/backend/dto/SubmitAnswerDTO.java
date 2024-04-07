package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code SubmitAnswerDTO} class is a simple data transfer object used for submitting answers to questions.
 */
public class SubmitAnswerDTO {
    private String answer;

    /**
     * Default constructor for {@code SubmitAnswerDTO}.
     */
    public SubmitAnswerDTO() {}

    /**
     * Retrieves the user's submitted answer.
     *
     * @return The answer submitted by the user.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the user's answer.
     *
     * @param answer The answer to be set.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
