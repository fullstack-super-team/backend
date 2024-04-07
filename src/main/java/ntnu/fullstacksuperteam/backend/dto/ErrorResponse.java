package ntnu.fullstacksuperteam.backend.dto;

/**
 * The {@code ErrorResponse} class is a simple data transfer object (DTO) that encapsulates error message information.
 */
public class ErrorResponse {
    private final String message;

    /**
     * Constructs a new {@code ErrorResponse} instance with a specific error message.
     *
     * @param message The error message to be encapsulated within this {@code ErrorResponse}.
     */
    public ErrorResponse(String message) {
        this.message = message;
    }

    /**
     * Retrieves the error message contained within this {@code ErrorResponse}.
     *
     * @return The error message as a {@code String}.
     */
    public String getMessage() {
        return message;
    }
}
