package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code SubmittedAnswerDTO} class is a generic data transfer object used for representing the result of a
 * submitted answer.

 * @param <T> The type of the submitted and correct answers, allowing for different kinds of answer formats.
 */
public class SubmittedAnswerDTO<T> {
    private T submittedAnswer;
    private T correctAnswers;
    private int pointsGiven;

    /**
     * Constructs a {@code SubmittedAnswerDTO} with the specified submitted answer, correct answers, and points awarded.
     *
     * @param submittedAnswer The answer submitted by the user.
     * @param correctAnswers The correct answer(s) for comparison.
     * @param pointsGiven The points awarded for the submitted answer.
     */
    public SubmittedAnswerDTO(T submittedAnswer, T correctAnswers, int pointsGiven) {
        this.submittedAnswer = submittedAnswer;
        this.correctAnswers = correctAnswers;
        this.pointsGiven = pointsGiven;
    }

    /**
     * Gets the submitted answer.
     *
     * @return The submitted answer.
     */
    public T getSubmittedAnswer() {
        return submittedAnswer;
    }

    /**
     * Gets the correct answers.
     *
     * @return The correct answers.
     */
    public T getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * Gets the points awarded for the submission.
     *
     * @return The points awarded.
     */
    public int getPointsGiven() {
        return pointsGiven;
    }
}
