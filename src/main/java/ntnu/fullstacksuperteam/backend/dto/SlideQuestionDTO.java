package ntnu.fullstacksuperteam.backend.dto;

public class SlideQuestionDTO extends QuestionDTO {
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
