package ntnu.fullstacksuperteam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enum representing the difficulty level of a quiz.
 */
public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD;

    /**
     * Converts an integer value into its corresponding {@code DifficultyLevel} enum constant.
     *
     * @param difficultyLevel The integer representation of the difficulty level.
     * @return The {@code DifficultyLevel} enum constant corresponding to the provided integer value.
     * @throws IllegalArgumentException If the provided integer does not correspond to a valid difficulty level.
     */
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
