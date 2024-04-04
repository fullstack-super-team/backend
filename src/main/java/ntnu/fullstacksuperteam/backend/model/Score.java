package ntnu.fullstacksuperteam.backend.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int points;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    public Score() {}

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getPoints() {
        return points;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
