package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SLIDE")
public class SlideAnswer extends Answer {
    private int min;
    private int max;
    private int correctValue;
    private int stepSize;

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

    public int getStepSize() {
        return stepSize;
    }

    public void setStepSize(int steps) {
        this.stepSize = steps;
    }
}
