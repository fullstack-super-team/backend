package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TextQuestion} class represents a question with text-based answers.
 */
@Entity
@DiscriminatorValue("TEXT")
public class TextQuestion extends Question {

    /**
     * A list of {@code TextAnswer} objects associated with this question.
     * Managed through JPA's {@code OneToMany} relationship.
     */
    @OneToMany(mappedBy = "question", cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
    private List<TextAnswer> answers;

    /**
     * Default constructor. Initializes the list of answers to an empty list.
     */
    public TextQuestion() {
        this.answers = new ArrayList<>();
    }

    /**
     * Constructs a {@code TextQuestion} by copying properties from an existing {@code Question}.
     *
     * @param question The {@code Question} object to copy properties from.
     */
    public TextQuestion(Question question) {
        super(question);
        this.answers = new ArrayList<>();
    }

    /**
     * Retrieves the list of text answers associated with this question.
     *
     * @return A {@code List} of {@code TextAnswer} objects.
     */
    public List<TextAnswer> getAnswers() {
        return answers;
    }

    /**
     * Sets the list of text answers for this question.
     *
     * @param answers A {@code List} of {@code TextAnswer} objects to be associated with this question.
     */
    public void setAnswers(List<TextAnswer> answers) {
        this.answers = answers;
    }

    /**
     * Adds a single {@code TextAnswer} to the list of answers for this question.
     *
     * @param answer The {@code TextAnswer} to add.
     */
    public void addAnswer(TextAnswer answer) {
        this.answers.add(answer);
    }
}
