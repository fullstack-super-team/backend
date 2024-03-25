package ntnu.fullstacksuperteam.backend.model;

public class SlideAnswer {
    private int min;
    private int max;
    private int correct;
    private int step;

    public SlideAnswer() {}

    public SlideAnswer(int min, int max, int correct, int step) {
        this.min = min;
        this.max = max;
        this.correct = correct;
        this.step = step;
    }

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

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
