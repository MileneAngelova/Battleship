package bg.softuni.battleship.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterDTO {
    @NotBlank
    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters long")
    private String username;

    @NotBlank
    @Size(min = 5, max = 20, message = "Full Name must be between 3 and 10 characters long")
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3)
    private String password;

    @NotBlank
    @Size(min = 3)
    private String confirmPassword;

    public RegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
