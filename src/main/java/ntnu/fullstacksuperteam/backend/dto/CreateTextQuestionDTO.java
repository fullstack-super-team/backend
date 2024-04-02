package ntnu.fullstacksuperteam.backend.dto;

import java.util.List;

public class CreateTextQuestionDTO extends CreateQuestionDTO {
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
