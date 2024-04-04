package ntnu.fullstacksuperteam.backend.dto;

public class TextAnswerDTO {
    private String text;
    private boolean isCorrect;

    public TextAnswerDTO() {}

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String toString() {
        return "TextAnswerDTO{" +
                "text='" + text + '\'' +
                ", correct=" + isCorrect +
                '}';
    }
}
