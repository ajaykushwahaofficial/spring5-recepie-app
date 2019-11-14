package guru.springframework.spring5receipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @OneToOne
    private Recipe recipe;
    private String recipeNote;

}
