package ntnu.fullstacksuperteam.backend.dto;

public class SlideAnswerDTO {
    private int min;
    private int max;
    private int correctValue;
    private int steps;

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

    public int getSteps() {
        return steps;
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
        stringBuilder.append("steps=").append(this.steps);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
