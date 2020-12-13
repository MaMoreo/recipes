package com.burntcity.recipes.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.burntcity.recipes.domain.Recipe;
import com.burntcity.recipes.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository repository;
	
	@BeforeEach   
	public void setUp() {
		MockitoAnnotations.initMocks(this);  // initialize Mocks
		recipeService = new RecipeServiceImpl(repository);
	}
	
	@Test
	void testGetRecipes() {
		Recipe rec = Recipe.builder().id(1L).build();
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(rec);
		
		when(repository.findAll()).thenReturn(recipesData);
		
		Set<Recipe> allRecipes = recipeService.getRecipes();
		assertEquals(1, allRecipes.size());
		verify(repository, times(1)).findAll();  // verify findAll() runs exactly once
	}

	
	@Test
    void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(repository.findById(Mockito.anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(repository, times(1)).findById(Mockito.anyLong());
        verify(repository, Mockito.never()).findAll();
    }
}
