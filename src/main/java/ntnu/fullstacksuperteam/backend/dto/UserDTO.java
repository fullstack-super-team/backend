package ntnu.fullstacksuperteam.backend.dto;

import ntnu.fullstacksuperteam.backend.model.User;

public class UserDTO {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;


    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
