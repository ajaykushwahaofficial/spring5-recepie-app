package guru.springframework.spring5receipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
