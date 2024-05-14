package bg.softuni.battleship.web;

import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.models.dtos.RegisterDTO;
import bg.softuni.battleship.models.dtos.ShipDTO;
import bg.softuni.battleship.models.entities.User;
import bg.softuni.battleship.services.ShipService;
import bg.softuni.battleship.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("battleModel")
    public BattleDTO initModel() {
        return new BattleDTO();
    }

    @GetMapping("/index")
    public String loggedOutIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String LoggedIn(Model model) {
        List<ShipDTO> userShips = this.shipService.getShipsOwnedBy(loggedUser.getId());
        List<ShipDTO> enemyShips = this.shipService.getEnemyShips(loggedUser.getId());
        List<ShipDTO> allSortedShips = this.shipService.getAllSortedShips();

        model.addAttribute("userShips", userShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("allSortedShips", allSortedShips);

        return "home";
    }
}
