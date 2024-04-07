package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.Category;
import ntnu.fullstacksuperteam.backend.model.DifficultyLevel;

import java.util.List;

/**
 * The {@code QuizDTO} class is a data transfer object that encapsulates the data of a quiz.
 */
public class QuizDTO {
    private String title;
    private String description;
    private boolean randomize;
    private DifficultyLevel difficultyLevel;
    private Category category;
    private List<QuestionDTO> questions;
    /**
     * Gets the title of the quiz.
     *
     * @return The title of the quiz.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the quiz.
     *
     * @return The description of the quiz.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the quiz questions are to be randomized.
     *
     * @return {@code true} if the questions are to be randomized, otherwise {@code false}.
     */
    public boolean getRandomize() {
        return randomize;
    }

    /**
     * Gets the difficulty level of the quiz.
     *
     * @return The difficulty level of the quiz.
     */
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Gets the category of the quiz.
     *
     * @return The category of the quiz.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Gets the list of questions in the quiz.
     *
     * @return The list of questions.
     */
    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    /**
     * Sets the title of the quiz.
     *
     * @param title The new title of the quiz.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the description of the quiz.
     *
     * @param description The new description of the quiz.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets whether the quiz questions should be randomized.
     *
     * @param randomize {@code true} to randomize the questions, otherwise {@code false}.
     */
    public void setRandomize(boolean randomize) {
        this.randomize = randomize;
    }

    /**
     * Sets the difficulty level of the quiz.
     *
     * @param difficultyLevel The new difficulty level of the quiz.
     */
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Sets the category of the quiz.
     *
     * @param category The new category of the quiz.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Sets the list of questions for the quiz.
     *
     * @param questions The new list of questions.
     */
    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
