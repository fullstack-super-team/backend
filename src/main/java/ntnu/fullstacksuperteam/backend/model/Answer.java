package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "answer_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
