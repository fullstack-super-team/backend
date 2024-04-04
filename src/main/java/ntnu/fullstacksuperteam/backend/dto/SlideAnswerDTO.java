package ntnu.fullstacksuperteam.backend.dto;

public class SlideAnswerDTO {
    private int min;
    private int max;
    private int correctValue;
    private int stepSize;

    public SlideAnswerDTO() {}

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getCorrectValue() {
        return correctValue;
    }

    public int getStepSize() {
        return stepSize;
    }

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
