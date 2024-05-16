package bg.softuni.battleship.web.ship;

import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.services.BattleService;
import bg.softuni.battleship.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {
    private final BattleService battleService;
    private final UserService userService;

    public BattleController(BattleService battleService, UserService userService) {
        this.battleService = battleService;
        this.userService = userService;
    }

    @GetMapping("/battle")
    public String battle() {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }
        return "redirect:home";
    }

    @PostMapping("/battle")
    public String battle(@Valid BattleDTO battleModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("battleModel", battleModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleModel", bindingResult);
            this.battleService.fire(battleModel);

            return "redirect:/home";
        }
        this.battleService.fire(battleModel);
        return "redirect:/home";
    }
}
