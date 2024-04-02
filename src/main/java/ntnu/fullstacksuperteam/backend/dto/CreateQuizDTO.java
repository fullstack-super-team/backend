package ntnu.fullstacksuperteam.backend.dto;

public class CreateQuizDTO {
    private final String title;
    private final String description;
    private final int difficultyLevel;

    public CreateQuizDTO(String title, String description, int difficultyLevel) {
        this.title = title;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
}
