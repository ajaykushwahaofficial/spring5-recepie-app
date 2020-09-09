package guru.springframework.spring5receipeapp.controllers;

import guru.springframework.spring5receipeapp.domain.Recipe;
import guru.springframework.spring5receipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMvc()throws Exception{
        MockMvc mockMvc=MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {
        //Given
        Set<Recipe> recipes=new HashSet<>();
        Recipe r1=new Recipe();
        r1.setId(1L);
        Recipe r2=new Recipe();
        r2.setId(2L);
        Recipe r3=new Recipe();
        r3.setId(3L);
        recipes.add(r1);
        recipes.add(r2);
        recipes.add(r3);
        when(recipeService.getReceipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> agc=ArgumentCaptor.forClass(Set.class);

        //when
        String viewName=indexController.getIndexPage(model);

        //then
        assertEquals("index",viewName);
        verify(recipeService,times(1)).getReceipes();
        verify(model,times(1)).addAttribute(eq("recipes"),agc.capture());
        Set<Recipe> setInController=agc.getValue();
        assertEquals(3,setInController.size());
    }
}