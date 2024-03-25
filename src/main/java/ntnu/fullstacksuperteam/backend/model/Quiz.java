package ntnu.fullstacksuperteam.backend.model;

import java.util.Date;
import java.util.List;

public class Quiz {
    private long id;
    private String title;
    private List<Question> questions;
    private Category category;
    private String difficultyLevel;
    private String description;
    private User author;
    private List<User> coAuthors;
    private Date UpdatedAt;
    private Date createdAt;


    public Quiz() {}

    public Quiz(long id, String title, List<Question> questions, Category category, String difficultyLevel, String description, User author, List<User> coAuthors, Date UpdatedAt, Date createdAt) {
        this.id = id;
        this.title = title;
        this.questions = questions;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        this.author = author;
        this.coAuthors = coAuthors;
        this.UpdatedAt = UpdatedAt;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getCoAuthors() {
        return coAuthors;
    }

    public void setCoAuthors(List<User> coAuthors) {
        this.coAuthors = coAuthors;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getLength() {
        return questions.size();
    }
}
