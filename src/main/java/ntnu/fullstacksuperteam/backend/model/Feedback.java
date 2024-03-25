package ntnu.fullstacksuperteam.backend.model;

public class Feedback {
    private long id;
    private User user;
    private String comment;

    public Feedback() {}

    public Feedback(long id, User user, String comment) {
        this.id = id;
        this.user = user;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public String toString() {
        return "Feedback: id=" + id + ", user=" + user + ", comment=" + comment;
    }

}
