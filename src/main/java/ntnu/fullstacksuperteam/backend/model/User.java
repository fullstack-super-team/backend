package ntnu.fullstacksuperteam.backend.model;

import ntnu.fullstacksuperteam.backend.dto.RegisterDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String username;
    private String password;

    public User() {}

    public User(Long userId) {
        this.userId = userId;
    }

    public User(RegisterDTO registerDTO) {
        this.name = registerDTO.getName();
        this.username = registerDTO.getUsername();
        this.password = registerDTO.getPassword();
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
    }
}
