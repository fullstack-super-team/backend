package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer {
    private String text;

    @JsonIgnore
    private boolean isCorrect;

    public TextAnswer() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextAnswer{");
        stringBuilder.append("text=").append(this.text);
        stringBuilder.append(", ");
        stringBuilder.append("correct=").append(this.isCorrect);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
