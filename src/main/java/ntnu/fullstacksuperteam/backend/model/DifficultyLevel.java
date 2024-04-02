package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD;

    @JsonCreator
    public static DifficultyLevel fromInt(int difficultyLevel) {
        return switch (difficultyLevel) {
            case 0 -> EASY;
            case 1 -> MEDIUM;
            case 2 -> HARD;
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
    }
}
