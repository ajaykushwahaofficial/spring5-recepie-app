package guru.springframework.spring5receipeapp.services;

import guru.springframework.spring5receipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getReceipes();
}
