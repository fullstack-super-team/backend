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
}
