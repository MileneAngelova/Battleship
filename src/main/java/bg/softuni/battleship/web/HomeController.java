package bg.softuni.battleship.web;

import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.models.dtos.ShipDTO;
import bg.softuni.battleship.services.ShipService;
import bg.softuni.battleship.services.UserService;
import bg.softuni.battleship.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
    private final ShipService shipService;
    private final LoggedUser loggedUser;


    public HomeController(ShipService shipService, UserService userService, LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @ModelAttribute("battleModel")
    public BattleDTO initModel() {
        return new BattleDTO();
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if (this.userService.isLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String LoggedIn(Model model) {

        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        Long loggedUserId = this.userService.getLoggedUserId();

        List<ShipDTO> userShips = this.shipService.getShipsOwnedBy(loggedUserId);
        List<ShipDTO> enemyShips = this.shipService.getEnemyShips(loggedUserId);
        List<ShipDTO> allSortedShips = this.shipService.getAllSortedShips();

        model.addAttribute("userShips", userShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("allSortedShips", allSortedShips);

        return "home";
    }
}
