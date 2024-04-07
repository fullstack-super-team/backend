package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code SlideQuestionDTO} class extends {@code QuestionDTO} to represent a question that requires a sliding scale answer.
 */
public class SlideQuestionDTO extends QuestionDTO {
    private SlideAnswerDTO answer;

    /**
     * Gets the {@code SlideAnswerDTO} associated with this question.
     *
     * @return The {@code SlideAnswerDTO} for this question.
     */
    public SlideAnswerDTO getSlideAnswerDTO() {
        return answer;
    }

    /**
     * Sets the {@code SlideAnswerDTO} for this question.
     *
     * @param answer The {@code SlideAnswerDTO} containing the answer details.
     */
    public void setAnswer(SlideAnswerDTO answer) {
        this.answer = answer;
    }

    /**
     * Provides a string representation of the {@code SlideQuestionDTO}, including the slide answer details.
     *
     * @return A string representation of this {@code SlideQuestionDTO}.
     */
    public String toString() {
        return "CreateSlideQuestionDTO{" +
                "slideAnswerDTO=" + answer +
                '}';
    }
}
