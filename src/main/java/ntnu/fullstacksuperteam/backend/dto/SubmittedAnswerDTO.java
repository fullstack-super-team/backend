package ntnu.fullstacksuperteam.backend.dto;

public class SubmittedAnswerDTO<T> {
    private T submittedAnswer;
    private T correctAnswer;
    private int pointsGiven;

    public SubmittedAnswerDTO(T submittedAnswer, T correctAnswer, int pointsGiven) {
        this.submittedAnswer = submittedAnswer;
        this.correctAnswer = correctAnswer;
        this.pointsGiven = pointsGiven;
    }

    public T getSubmittedAnswer() {
        return submittedAnswer;
    }

    public T getCorrectAnswer() {
        return correctAnswer;
    }

    public int getPointsGiven() {
        return pointsGiven;
    }
}
