package ntnu.fullstacksuperteam.backend.dto;

public class SubmittedAnswerDTO<T> {
    private T submittedAnswer;
    private T correctAnswers;
    private int pointsGiven;

    public SubmittedAnswerDTO(T submittedAnswer, T correctAnswers, int pointsGiven) {
        this.submittedAnswer = submittedAnswer;
        this.correctAnswers = correctAnswers;
        this.pointsGiven = pointsGiven;
    }

    public T getSubmittedAnswer() {
        return submittedAnswer;
    }

    public T getCorrectAnswers() {
        return correctAnswers;
    }

    public int getPointsGiven() {
        return pointsGiven;
    }
}
