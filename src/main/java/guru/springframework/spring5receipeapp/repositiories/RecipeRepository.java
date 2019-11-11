package guru.springframework.spring5receipeapp.repositiories;

import guru.springframework.spring5receipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
