package ntnu.fullstacksuperteam.backend.dto;

public class TextAnswerDTO {
    private String text;
    private boolean correct;

    public TextAnswerDTO() {}

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String toString() {
        return "TextAnswerDTO{" +
                "text='" + text + '\'' +
                ", correct=" + correct +
                '}';
    }
}
