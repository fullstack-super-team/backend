package ntnu.fullstacksuperteam.backend.dto;

public class TrueOrFalseAnswerDTO {
    private long id;
    private String text;
    private boolean isCorrect;

    public TrueOrFalseAnswerDTO() {}

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
}
