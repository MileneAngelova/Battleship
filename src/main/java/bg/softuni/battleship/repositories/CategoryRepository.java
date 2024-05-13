package bg.softuni.battleship.repositories;

import bg.softuni.battleship.models.entities.Category;
import bg.softuni.battleship.models.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

Category findByName(CategoryNameEnum name);
}
