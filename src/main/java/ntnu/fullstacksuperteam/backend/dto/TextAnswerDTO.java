package ntnu.fullstacksuperteam.backend.dto;

public class TextAnswerDTO {
    private long id;
    private String text;
    private boolean isCorrect;

    public TextAnswerDTO() {}

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String toString() {
        return "TextAnswerDTO{" +
                "text='" + text + '\'' +
                ", correct=" + isCorrect +
                '}';
    }
}
