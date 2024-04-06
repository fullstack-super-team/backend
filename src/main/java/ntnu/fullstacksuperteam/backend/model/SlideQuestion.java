package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("SLIDE")
public class SlideQuestion extends Question {
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private SlideAnswer answer;

    public SlideQuestion() {}

    public SlideQuestion(Question question) {
        super(question);
    }
    public SlideAnswer getAnswer() {
        return answer;
    }


    public void setAnswer(SlideAnswer answer) {
        this.answer = answer;
    }
}
