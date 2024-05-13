package bg.softuni.battleship.session;

import bg.softuni.battleship.models.entities.Ship;
import bg.softuni.battleship.models.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
public class LoggedUser {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String password;

    private Set<Ship> ships;


    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public LoggedUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoggedUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public void logout() {
        this.id = null;
        this.username = null;
        this.fullName = null;
        this.email = null;
        this.password = null;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public LoggedUser setShips(Set<Ship> ships) {
        this.ships = ships;
        return this;
    }
}
