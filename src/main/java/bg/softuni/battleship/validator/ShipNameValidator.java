package bg.softuni.battleship.validator;

import bg.softuni.battleship.repositories.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShipNameValidator implements ConstraintValidator<UniqShipName, String> {
    private final ShipRepository shipRepository;

    public ShipNameValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.shipRepository.findByName(value).isEmpty();
    }
}
