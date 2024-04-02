package ntnu.fullstacksuperteam.backend.dto;

public class CreateSlideQuestionDTO extends CreateQuestionDTO {
    private SlideAnswerDTO answer;

    public SlideAnswerDTO getSlideAnswerDTO() {
        return answer;
    }

    public void setAnswer(SlideAnswerDTO answer) {
        this.answer = answer;
    }

    public String toString() {
        return "CreateSlideQuestionDTO{" +
                "slideAnswerDTO=" + answer +
                '}';
    }
}
