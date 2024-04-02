package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SLIDE")
public class SlideAnswer extends Answer {
    private int min;
    private int max;
    private int correctValue;
    private int steps;

    public SlideAnswer() {}

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCorrectValue() {
        return correctValue;
    }

    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
