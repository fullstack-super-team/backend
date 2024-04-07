package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.dto.TrueOrFalseAnswerDTO;

import java.util.List;

/**
 * The {@code TrueOrFalseQuestionDTO} class extends {@code QuestionDTO} to represent a question that can be answered with either true or false.
 */
public class TrueOrFalseQuestionDTO extends QuestionDTO {
    private List<TrueOrFalseAnswerDTO> answers;

    /**
     * Gets the list of true or false answers associated with this question.
     *
     * @return A list of {@code TrueOrFalseAnswerDTO} objects.
     */
    public List<TrueOrFalseAnswerDTO> getTextAnswerDTOS() {
        return answers;
    }

    /**
     * Sets the list of answers for this true or false question. Validates that exactly two answers are provided.
     *
     * @param answers A list of {@code TrueOrFalseAnswerDTO} objects to be associated with this question.
     * @throws IllegalArgumentException if the provided list does not contain exactly two answers.
     */
    public void setAnswers(List<TrueOrFalseAnswerDTO> answers) {
        if (answers.size() != 2) {
            throw new IllegalArgumentException("True or false questions must have exactly two answers");
        }
        this.answers = answers;
    }

    /**
     * Provides a string representation of the {@code TrueOrFalseQuestionDTO}, including details of its answers.
     *
     * @return A string representation of this {@code TrueOrFalseQuestionDTO}.
     */
    public String toString() {
        return "CreateTextQuestionDTO{" +
                "answers=" + answers +
                '}';
    }

}
