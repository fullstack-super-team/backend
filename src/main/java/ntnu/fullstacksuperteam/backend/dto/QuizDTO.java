package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.Category;
import ntnu.fullstacksuperteam.backend.model.DifficultyLevel;

import java.util.List;

public class QuizDTO {
    private String title;
    private String description;
    private DifficultyLevel difficultyLevel;
    private Category category;
    private List<QuestionDTO> questions;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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
}
