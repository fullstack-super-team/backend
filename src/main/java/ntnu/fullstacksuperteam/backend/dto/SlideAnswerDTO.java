package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code SlideAnswerDTO} class represents a data transfer object for answers that are based on a sliding scale.
 */
public class SlideAnswerDTO {
    private long id;
    private int min;
    private int max;
    private int correctValue;
    private int stepSize;

    /**
     * Default constructor for {@code SlideAnswerDTO}.
     */
    public SlideAnswerDTO() {}

    /**
     * Gets the identifier of the slide answer.
     *
     * @return The identifier of the slide answer.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the minimum value of the sliding scale.
     *
     * @return The minimum value of the scale.
     */
    public int getMin() {
        return min;
    }

    /**
     * Gets the maximum value of the sliding scale.
     *
     * @return The maximum value of the scale.
     */
    public int getMax() {
        return max;
    }

    /**
     * Gets the correct value within the sliding scale.
     *
     * @return The correct value.
     */
    public int getCorrectValue() {
        return correctValue;
    }

    /**
     * Gets the step size of the sliding scale.
     *
     * @return The step size for the slider.
     */
    public int getStepSize() {
        return stepSize;
    }

    /**
     * Sets the identifier of the slide answer.
     *
     * @param id The new identifier for the slide answer.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the minimum value of the sliding scale.
     *
     * @param min The new minimum value of the scale.
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Sets the maximum value of the sliding scale.
     *
     * @param max The new maximum value of the scale.
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Sets the correct value within the sliding scale.
     *
     * @param correctValue The new correct value.
     */
    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    /**
     * Sets the step size of the sliding scale.
     *
     * @param stepSize The new step size for the slider.
     */
    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    /**
     * Provides a string representation of the {@code SlideAnswerDTO}.
     *
     * @return A string representation of the slide answer details.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SlideAnswerDTO{");
        stringBuilder.append("min=").append(this.min);
        stringBuilder.append(", ");
        stringBuilder.append("max=").append(this.max);
        stringBuilder.append(", ");
        stringBuilder.append("correctValue=").append(this.correctValue);
        stringBuilder.append(", ");
        stringBuilder.append("steps=").append(this.stepSize);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
