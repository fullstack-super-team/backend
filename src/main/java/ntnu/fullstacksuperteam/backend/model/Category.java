package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enum representing various categories of questions.
 */
public enum Category {
    FOOD,
    SPORT,
    SCIENCE,
    HISTORY,
    CULTURE,
    GENERAL;

    /**
     * Converts a string value into its corresponding {@code Category} enum constant.
     *
     * @param category The string representation of the category.
     * @return The {@code Category} enum constant corresponding to the provided string,
     * or {@code GENERAL} if the string does not match any specific category.
     */
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
