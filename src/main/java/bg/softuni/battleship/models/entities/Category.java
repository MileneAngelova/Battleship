package bg.softuni.battleship.models.entities;

import bg.softuni.battleship.models.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;


    public Category() {
    }

    public Category(CategoryNameEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
