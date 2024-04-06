package ntnu.fullstacksuperteam.backend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ntnu.fullstacksuperteam.backend.model.Category;

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

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public String getMultimediaUrl() {
        return multimediaUrl;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMultimediaUrl(String multimediaUrl) {
        this.multimediaUrl = multimediaUrl;
    }

    public void setType(String type) {
        this.type = type;
    }
}
