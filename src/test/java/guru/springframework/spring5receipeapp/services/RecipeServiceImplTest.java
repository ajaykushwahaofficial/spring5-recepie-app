package guru.springframework.spring5receipeapp.services;

import guru.springframework.spring5receipeapp.domain.Recipe;
import guru.springframework.spring5receipeapp.repositiories.RecipeRepository;
import javafx.beans.binding.Bindings;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getReceipes() {
        Recipe recipe=new Recipe();
        Set<Recipe> recipeSet=new HashSet<>();
        recipeSet.add(recipe);
        when(recipeService.getReceipes()).thenReturn(recipeSet);
        //assertEquals(0,recipeService.getReceipes().size()); when no elements
        assertEquals(1,recipeService.getReceipes().size());
        //To verify that recipe repository called only once
        verify(recipeRepository,times(1));
    }
}