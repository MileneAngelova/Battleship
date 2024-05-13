package bg.softuni.battleship.services;

import bg.softuni.battleship.models.dtos.LoginDTO;
import bg.softuni.battleship.models.dtos.RegisterDTO;
import bg.softuni.battleship.models.entities.User;
import bg.softuni.battleship.repositories.UserRepository;
import bg.softuni.battleship.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
//    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean userExist(LoginDTO loginDTO) {
        Optional<User> byUsername = this.userRepository.findByUsername(loginDTO.getUsername());
        return byUsername.isPresent();
    }

    public boolean register(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registerDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registerDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        User newUser = new User();
        newUser.setUsername(registerDTO.getUsername());
        newUser.setPassword(registerDTO.getPassword());
        newUser.setEmail(registerDTO.getEmail());
        newUser.setFullName(registerDTO.getFullName());

        this.userRepository.save(newUser);
        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> optUser = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (optUser.isEmpty()) {
            return false;
        }

        this.loggedUser.login(optUser.get());
        return true;
    }
}
