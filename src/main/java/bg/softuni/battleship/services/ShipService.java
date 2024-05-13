package bg.softuni.battleship.services;

import bg.softuni.battleship.models.dtos.AddShipDTO;
import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.models.dtos.ShipDTO;
import bg.softuni.battleship.models.entities.Category;
import bg.softuni.battleship.models.entities.Ship;
import bg.softuni.battleship.models.entities.User;
import bg.softuni.battleship.repositories.CategoryRepository;
import bg.softuni.battleship.repositories.ShipRepository;
import bg.softuni.battleship.repositories.UserRepository;
import bg.softuni.battleship.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;


    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository, UserRepository userRepository, LoggedUser loggedUser, LoggedUser loggedUser1) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser1;
    }

    public boolean shipCreated(AddShipDTO addShipDTO) {
        Optional<Ship> optShip = this.shipRepository.findByName(addShipDTO.getName());
        if (optShip.isPresent()) {
            return false;
        }

//        CategoryNameEnum name = switch (addShipDTO.getCategory()) {
//            case 0 -> CategoryNameEnum.BATTLE;
//            case 1 -> CategoryNameEnum.PATROL;
//            case 2 -> CategoryNameEnum.CARGO;
//            default -> CategoryNameEnum.BATTLE;
//        };

        Category category = this.categoryRepository.findByName(addShipDTO.getCategory());
        Optional<User> owner = this.userRepository.findByUsername(this.loggedUser.getUsername());

        Ship newShip = new Ship();

        newShip.setName(addShipDTO.getName());
        newShip.setPower(addShipDTO.getPower());
        newShip.setHealth(addShipDTO.getHealth());
        newShip.setCreated(addShipDTO.getCreated());
        newShip.setCategory(category);
        newShip.setUser(owner.get());

        this.shipRepository.save(newShip);

        return true;
    }

    public List<ShipDTO> getShipsOwnedBy(Long ownerId) {
        return this.shipRepository.findByUserId(ownerId)
                .stream().map(ShipDTO::new)
                .collect(Collectors.toList());
    }

    public List<ShipDTO> getEnemyShips(Long enemyId) {
        return this.shipRepository.findByUserIdNot(enemyId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }
}
