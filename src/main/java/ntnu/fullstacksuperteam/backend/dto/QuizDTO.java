package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.Category;
import ntnu.fullstacksuperteam.backend.model.DifficultyLevel;

import java.util.List;

public class QuizDTO {
    private String title;
    private String description;
    private boolean randomize;
    private DifficultyLevel difficultyLevel;
    private Category category;
    private List<QuestionDTO> questions;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getRandomize() {
        return randomize;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Category getCategory() {
        return category;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRandomize(boolean randomize) {
        this.randomize = randomize;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
