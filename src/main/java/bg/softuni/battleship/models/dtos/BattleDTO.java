package bg.softuni.battleship.models.dtos;

import jakarta.validation.constraints.Positive;

public class BattleDTO {
    private Long id;
    @Positive
    private Long attackerId;

    @Positive
    private Long defenderId;

    public BattleDTO() {
    }

    public Long getAttackerId() {
        return attackerId;
    }

    public BattleDTO setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public BattleDTO setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }

    public Long getId() {
        return id;
    }
}
