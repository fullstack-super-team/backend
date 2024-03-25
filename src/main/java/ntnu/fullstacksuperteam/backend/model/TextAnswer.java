package ntnu.fullstacksuperteam.backend.model;

public class TextAnswer extends Answer {
    private String text;
    private boolean correct;

    public TextAnswer() {}

    public TextAnswer(long id, String text, boolean correct) {
        super(id);
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
