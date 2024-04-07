package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Represents a slide answer type within the quiz system, extending the generic Answer class.
 */
@Entity
@DiscriminatorValue("SLIDE")
public class SlideAnswer extends Answer {
    private int min;
    private int max;
    private int correctValue;
    private int stepSize;

    /**
     * Constructs a new, empty SlideAnswer instance.
     */
    public SlideAnswer() {}

    /**
     * Retrieves the minimum value of the range for this slide answer.
     *
     * @return The minimum value allowed as an answer.
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets the minimum value of the range for this slide answer.
     *
     * @param min The minimum value allowed as an answer.
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Retrieves the maximum value of the range for this slide answer.
     *
     * @return The maximum value allowed as an answer.
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets the maximum value of the range for this slide answer.
     *
     * @param max The maximum value allowed as an answer.
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Retrieves the correct value within the range for this slide answer.
     *
     * @return The correct value that represents the answer.
     */
    public int getCorrectValue() {
        return correctValue;
    }

    /**
     * Sets the correct value within the range for this slide answer.
     *
     * @param correctValue The correct value that represents the answer.
     */
    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    /**
     * Retrieves the step size for this slide answer. The step size defines
     * the valid increments within the range between the minimum and maximum values.
     *
     * @return The step size for incrementing between values.
     */
    public int getStepSize() {
        return stepSize;
    }

    /**
     * Sets the step size for this slide answer. This defines the valid increments
     * within the range that the answer can take.
     *
     * @param steps The step size for incrementing between values.
     */
    public void setStepSize(int steps) {
        this.stepSize = steps;
    }
}
