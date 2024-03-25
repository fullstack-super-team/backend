package ntnu.fullstacksuperteam.backend.model;

public class Tag {
    private String text;

    public Tag() {}

    public Tag(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
