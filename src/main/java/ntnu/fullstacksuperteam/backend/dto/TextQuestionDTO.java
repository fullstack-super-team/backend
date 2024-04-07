package ntnu.fullstacksuperteam.backend.dto;

import java.util.List;

/**
 * The {@code TextQuestionDTO} class extends {@code QuestionDTO} to represent a question that has text-based answers.
 */
public class TextQuestionDTO extends QuestionDTO {
    private List<TextAnswerDTO> answers;

    /**
     * Gets the list of text answers associated with this question.
     *
     * @return A list of {@code TextAnswerDTO} objects.
     */
    public List<TextAnswerDTO> getTextAnswerDTOS() {
        return answers;
    }

    /**
     * Sets the list of text answers for this question.
     *
     * @param answers A list of {@code TextAnswerDTO} objects to be associated with this question.
     */
    public void setAnswers(List<TextAnswerDTO> answers) {
        this.answers = answers;
    }

    /**
     * Provides a string representation of the {@code TextQuestionDTO}, including details of its answers.
     *
     * @return A string representation of this {@code TextQuestionDTO}.
     */
    public String toString() {
        return "CreateTextQuestionDTO{" +
                "answers=" + answers +
                '}';
    }
}
