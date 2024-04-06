package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("TEXT")
public class TextQuestion extends Question {
    @OneToMany(mappedBy = "question", cascade = { CascadeType.ALL, CascadeType.REMOVE}, orphanRemoval = true)
    private List<TextAnswer> answers;

    public TextQuestion() {
        this.answers = new ArrayList<>();
    }

    public TextQuestion(Question question) {
        super(question);
        this.answers = new ArrayList<>();
    }

    public List<TextAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<TextAnswer> answers) {
        this.answers = answers;
    }

    public void addAnswer(TextAnswer answer) {
        this.answers.add(answer);
    }
}
