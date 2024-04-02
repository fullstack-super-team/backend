package ntnu.fullstacksuperteam.backend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateTextQuestionDTO.class, name = "TEXT"),
        @JsonSubTypes.Type(value = CreateSlideQuestionDTO.class, name = "SLIDE"),
        @JsonSubTypes.Type(value = CreateQuestionDTO.class, name = "TRUE_OR_FALSE")
})
public class CreateQuestionDTO {
    private String text;
    private int points;
    private String multimediaUrl;
    private String type;

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
}
