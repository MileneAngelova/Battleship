package bg.softuni.battleship.web.ship;

import bg.softuni.battleship.models.dtos.BattleDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {
    @PostMapping("/battle")
    public String battle(@Valid BattleDTO battleModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("battleModel", battleModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleModel", bindingResult);

        return "redirect:/home";
    }
}
