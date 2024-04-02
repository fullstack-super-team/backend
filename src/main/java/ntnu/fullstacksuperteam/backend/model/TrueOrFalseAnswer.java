package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TRUE_OR_FALSE")
public class TrueOrFalseAnswer extends Answer {
    private String text;

    @JsonIgnore
    private boolean correct;

    public TrueOrFalseAnswer() {}

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
