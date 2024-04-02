package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.Category;
import ntnu.fullstacksuperteam.backend.model.DifficultyLevel;

public class CreateQuizDTO {
    private String title;
    private String description;
    private DifficultyLevel difficultyLevel;
    private Category category;

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
}
