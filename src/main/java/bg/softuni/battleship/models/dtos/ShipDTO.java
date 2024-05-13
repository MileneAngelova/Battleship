package bg.softuni.battleship.models.dtos;

import bg.softuni.battleship.models.entities.Ship;
import bg.softuni.battleship.models.entities.User;

public class ShipDTO {
    private Long id;
    private String shipName;
    private Long health;
    private Long power;
    private RegisterDTO owner;

    public ShipDTO() {
    }

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.shipName = ship.getName();
        this.health = ship.getHealth();
        this.power = ship.getPower();
    }

    public String getShipName() {
        return shipName;
    }

    public ShipDTO setShipName(String shipName) {
        this.shipName = shipName;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegisterDTO getOwner() {
        return owner;
    }

    public ShipDTO setOwner(RegisterDTO owner) {
        this.owner = owner;
        return this;
    }
}
