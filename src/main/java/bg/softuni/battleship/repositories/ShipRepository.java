package bg.softuni.battleship.repositories;

import bg.softuni.battleship.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByName(String name);

    List<Ship> findByUserId(Long userId);

    List<Ship> findByUserIdNot(Long userId);

    List<Ship> findAllByOrderByNameAscHealthAscPowerAsc();

    Optional<Ship> findById(Long id);
}
