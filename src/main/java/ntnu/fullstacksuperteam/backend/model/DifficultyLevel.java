package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD;

    @JsonCreator
    public static DifficultyLevel fromInt(int difficultyLevel) {
        return switch (difficultyLevel) {
            case 1 -> EASY;
            case 2 -> MEDIUM;
            case 3 -> HARD;
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
    }
}
