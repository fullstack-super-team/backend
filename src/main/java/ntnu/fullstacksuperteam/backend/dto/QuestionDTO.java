package ntnu.fullstacksuperteam.backend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ntnu.fullstacksuperteam.backend.model.Category;

/**
 * The {@code QuestionDTO} class serves as a general data transfer object for questions,
 * supporting different types of questions like text, slide, and true or false.
 * It uses Jackson annotations to manage polymorphic JSON structures,
 * enabling the deserialization of JSON into specific {@code QuestionDTO} subclasses based on the 'type' property.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextQuestionDTO.class, name = "TEXT"),
        @JsonSubTypes.Type(value = SlideQuestionDTO.class, name = "SLIDE"),
        @JsonSubTypes.Type(value = TrueOrFalseQuestionDTO.class, name = "TRUE_OR_FALSE")
})
public class QuestionDTO {
    private long id;
    private String text;
    private int points;
    private String multimediaUrl;
    private String type;

    /**
     * Gets the question ID.
     *
     * @return The ID of the question.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the question text.
     *
     * @return The text of the question.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the number of points the question is worth.
     *
     * @return The point value of the question.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Gets the URL for any multimedia associated with the question.
     *
     * @return The multimedia URL, if any.
     */
    public String getMultimediaUrl() {
        return multimediaUrl;
    }

    /**
     * Gets the type of question.
     *
     * @return The type of the question.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the question ID.
     *
     * @param id The new ID for the question.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the question text.
     *
     * @param text The new text for the question.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the points the question is worth.
     *
     * @param points The new point value for the question.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Sets the multimedia URL for the question.
     *
     * @param multimediaUrl The new multimedia URL.
     */
    public void setMultimediaUrl(String multimediaUrl) {
        this.multimediaUrl = multimediaUrl;
    }

    /**
     * Sets the type of question.
     *
     * @param type The new type of the question.
     */
    public void setType(String type) {
        this.type = type;
    }
}
