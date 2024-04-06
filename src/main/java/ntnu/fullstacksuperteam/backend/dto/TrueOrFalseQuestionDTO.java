package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.dto.TrueOrFalseAnswerDTO;

import java.util.List;

public class TrueOrFalseQuestionDTO extends QuestionDTO {
    private List<TrueOrFalseAnswerDTO> answers;

    public List<TrueOrFalseAnswerDTO> getTextAnswerDTOS() {
        return answers;
    }

    public void setAnswers(List<TrueOrFalseAnswerDTO> answers) {
        if (answers.size() != 2) {
            throw new IllegalArgumentException("True or false questions must have exactly two answers");
        }
        this.answers = answers;
    }
    public String toString() {
        return "CreateTextQuestionDTO{" +
                "answers=" + answers +
                '}';
    }

}
