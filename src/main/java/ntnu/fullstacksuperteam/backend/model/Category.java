package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    FOOD,
    SPORT,
    SCIENCE,
    HISTORY,
    CULTURE,
    GENERAL;

    @JsonCreator
    public static Category fromString(String category) {
        return switch (category) {
            case "food" -> FOOD;
            case "sport" -> SPORT;
            case "science" -> SCIENCE;
            case "history" -> HISTORY;
            case "culture" -> CULTURE;
            default -> GENERAL;
        };
    }

}
