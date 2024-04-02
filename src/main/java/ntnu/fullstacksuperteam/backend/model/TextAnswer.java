package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer {
    private String text;

    @JsonIgnore
    private boolean correct;

    public TextAnswer() {}

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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextAnswer{");
        stringBuilder.append("text=").append(this.text);
        stringBuilder.append(", ");
        stringBuilder.append("correct=").append(this.correct);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
