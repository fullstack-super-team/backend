package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TrueOrFalseQuestion} class extends the {@code Question} class to specifically
 * represent questions that are answered with a true or false response.
 */
@Entity
@DiscriminatorValue("TRUE_OR_FALSE")
public class TrueOrFalseQuestion extends Question {

    /**
     * A list of {@code TrueOrFalseAnswer} objects. These represent the answers
     * associated with this true or false question. Managed via JPA's {@code OneToMany}
     * relationship, it supports automatic persistence actions.
     */
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrueOrFalseAnswer> answers;

    /**
     * Default constructor. Initializes the list of answers to an empty list.
     */
    public TrueOrFalseQuestion() {
        this.answers = new ArrayList<>();
    }

    /**
     * Constructs a {@code TrueOrFalseQuestion} by copying properties from an
     * existing {@code Question}.
     *
     * @param question The {@code Question} object to copy properties from.
     */
    public TrueOrFalseQuestion(Question question) {
        super(question);
        this.answers = new ArrayList<>();
    }

    /**
     * Retrieves the list of true or false answers associated with this question.
     *
     * @return A {@code List} of {@code TrueOrFalseAnswer} objects.
     */
    public List<TrueOrFalseAnswer> getAnswers() {
        return answers;
    }

    /**
     * Sets the list of true or false answers for this question.
     *
     * @param answers A {@code List} of {@code TrueOrFalseAnswer} objects to be
     *                associated with this question.
     */
    public void setAnswers(List<TrueOrFalseAnswer> answers) {
        this.answers = answers;
    }

    /**
     * Adds a single {@code TrueOrFalseAnswer} to the list of answers for this question.
     *
     * @param answer The {@code TrueOrFalseAnswer} to add.
     */
    public void addAnswer(TrueOrFalseAnswer answer) {
        this.answers.add(answer);
    }
}
