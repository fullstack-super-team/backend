package ntnu.fullstacksuperteam.backend.model;

/**
 * The {@code Token} class encapsulates an authentication or authorization token.
 */
public class Token {
    String token;

    /**
     * Constructs a new {@code Token} instance with the specified token value.
     *
     * @param token The token string to be encapsulated within this {@code Token} object.
     */
    public Token(String token) {
        this.token = token;
    }

    /**
     * Retrieves the token value encapsulated by this {@code Token} object.
     *
     * @return The token string.
     */
    public String getToken() {
        return token;
    }
}
