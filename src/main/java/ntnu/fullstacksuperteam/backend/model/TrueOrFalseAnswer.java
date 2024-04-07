package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TRUE_OR_FALSE")
public class TrueOrFalseAnswer extends Answer {
    private String text;
    private boolean isCorrect;

    public TrueOrFalseAnswer() {}

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
}
