package ntnu.fullstacksuperteam.backend.model;

import java.util.Date;

public class Score {
    private long id;
    private User user;
    private int points;
    private Quiz quiz;
    private Date date;

    public Score() {}

    public Score(long id, User user, int points, Quiz quiz, Date date) {
        this.id = id;
        this.user = user;
        this.points = points;
        this.quiz = quiz;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Congratulations " + user.getFirstName() + "! You scored " + points + "/" + quiz.getLength() + "correct answers on the quiz" + quiz.getTitle() + "!";
    }
}
