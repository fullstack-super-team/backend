package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.TrueOrFalseAnswer;

import java.util.List;

public class CreateTrueOrFalseQuestionDTO extends CreateQuestionDTO {
    private List<TrueOrFalseAnswer> answers;

    public List<TrueOrFalseAnswer> getTextAnswerDTOS() {
        return answers;
    }

    public void setAnswers(List<TrueOrFalseAnswer> answers) {
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
