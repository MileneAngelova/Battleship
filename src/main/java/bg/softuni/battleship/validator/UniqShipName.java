package bg.softuni.battleship.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ShipNameValidator.class)
public @interface UniqShipName {
    String message() default "Invalid Email";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
