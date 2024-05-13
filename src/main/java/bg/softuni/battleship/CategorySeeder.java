package bg.softuni.battleship;

import bg.softuni.battleship.models.entities.Category;
import bg.softuni.battleship.models.enums.CategoryNameEnum;
import bg.softuni.battleship.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {

            for (CategoryNameEnum nameEnum : CategoryNameEnum.values()) {
               Category newCategory = new Category(nameEnum);
               categoryRepository.save(newCategory);
            }
//            List<Category> categories = Arrays.stream(CategoryNameEnum.values())
//                    .map(name -> new Category())
//                    .collect(Collectors.toList());

//            this.categoryRepository.saveAll(categories);
        }
    }
}
