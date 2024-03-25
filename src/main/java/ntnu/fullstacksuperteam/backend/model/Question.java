package ntnu.fullstacksuperteam.backend.model;

import java.util.Date;
import java.util.List;

public class Question {
    private long id;
    private String text;
    private List<Answer> answers;
    private List<Tag> tags;
    private String multimediaUrl;
    private Date createdAt;
    private Date updatedAt;
    private int points;

    public Question() {}

    public Question(long id, String text, List<Answer> answers, List<Tag> tags, String multimediaUrl, Date createdAt, Date updatedAt, int points) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.tags = tags;
        this.multimediaUrl = multimediaUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getMultimedia() {
        return multimediaUrl;
    }

    public void setMultimedia(String multimediaUrl) {
        this.multimediaUrl = multimediaUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}