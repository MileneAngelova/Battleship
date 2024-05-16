package bg.softuni.battleship.web.ship;

import bg.softuni.battleship.models.dtos.AddShipDTO;
import bg.softuni.battleship.services.ShipService;
import bg.softuni.battleship.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddShipController {
    private final ShipService shipService;
private final UserService userService;

    public AddShipController(ShipService shipService, UserService userService) {
        this.shipService = shipService;
        this.userService = userService;
    }

    @ModelAttribute("shipModel")
    public AddShipDTO shipModel() {
        return new AddShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip() {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addNewShip(@Valid AddShipDTO shipModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.shipService.shipCreated(shipModel)) {
            redirectAttributes.addFlashAttribute("shipModel", shipModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipModel", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }

}
