package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    FOOD,
    DRINK,
    CLOTHING,
    ELECTRONICS,
    BOOKS,
    GENERAL;

    @JsonCreator
    public static Category fromString(String category) {
        return switch (category) {
            case "food" -> FOOD;
            case "drink" -> DRINK;
            case "clothing" -> CLOTHING;
            case "electronics" -> ELECTRONICS;
            case "books" -> BOOKS;
            default -> GENERAL;
        };
    }

}
