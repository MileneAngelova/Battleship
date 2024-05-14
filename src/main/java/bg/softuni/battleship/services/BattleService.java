package bg.softuni.battleship.services;

import bg.softuni.battleship.models.dtos.BattleDTO;
import bg.softuni.battleship.models.entities.Ship;
import bg.softuni.battleship.repositories.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {
    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void fire(BattleDTO battleData) {
        Optional<Ship> attackerOpt = this.shipRepository.findById(battleData.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById(battleData.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attackerShip = attackerOpt.get();
        Ship defenderShip = defenderOpt.get();

        long healthAfterAttack = defenderShip.getHealth() - attackerShip.getPower();

        if (healthAfterAttack <= 0) {
            this.shipRepository.delete(defenderShip);
        } else {
            defenderShip.setHealth(healthAfterAttack);
            this.shipRepository.save(defenderShip);
        }

    }
}
