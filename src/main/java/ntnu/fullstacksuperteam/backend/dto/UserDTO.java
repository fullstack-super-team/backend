package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.User;

public class UserDTO {
    private final long userId;
    private final String name;
    private final String username;


    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.username = user.getUsername();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return getName() + getUsername();
    }
}
