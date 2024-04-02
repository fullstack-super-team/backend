package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("TRUE_OR_FALSE")
public class TrueOrFalseQuestion extends Question {
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<TrueOrFalseAnswer> answers;

    public TrueOrFalseQuestion() {
        this.answers = new ArrayList<>();
    }

    public List<TrueOrFalseAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<TrueOrFalseAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(TrueOrFalseAnswer answer) {
        this.answers.add(answer);
    }
}
