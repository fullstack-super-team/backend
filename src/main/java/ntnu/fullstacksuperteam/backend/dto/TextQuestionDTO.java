package ntnu.fullstacksuperteam.backend.dto;

import java.util.List;

public class TextQuestionDTO extends QuestionDTO {
    private List<TextAnswerDTO> answers;

    public List<TextAnswerDTO> getTextAnswerDTOS() {
        return answers;
    }

    public void setAnswers(List<TextAnswerDTO> answers) {
        this.answers = answers;
    }
    public String toString() {
        return "CreateTextQuestionDTO{" +
                "answers=" + answers +
                '}';
    }
}
