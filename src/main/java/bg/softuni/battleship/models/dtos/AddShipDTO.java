package bg.softuni.battleship.models.dtos;

import bg.softuni.battleship.models.enums.CategoryNameEnum;
import bg.softuni.battleship.validator.UniqShipName;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AddShipDTO {
    @NotBlank(message = "The field must not be empty")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters long.")
    @UniqShipName(message = "The name is already taken")
    private String name;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate created;

    @NotNull
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public AddShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public AddShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public AddShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public AddShipDTO setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
