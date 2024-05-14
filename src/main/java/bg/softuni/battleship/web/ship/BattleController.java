package bg.softuni.battleship.web.ship;

import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.services.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid BattleDTO battleModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

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
