package com.burntcity.recipes.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.burntcity.recipes.domain.Recipe;
import com.burntcity.recipes.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeService service;
	
	@Mock
	RecipeRepository repository;
	
	@BeforeEach   
	public void setUp() {
		MockitoAnnotations.initMocks(this);  // initialize Mocks
		service = new RecipeServiceImpl(repository);
	}
	
	@Test
	void testGetRecipes() {
		Recipe rec = new Recipe();
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(rec);
		
		when(repository.findAll()).thenReturn(recipesData);
		
		Set<Recipe> allRecipes = service.getRecipes();
		assertEquals(1, allRecipes.size());
		verify(repository, times(1)).findAll();  // verify findAll() runs exactly once
	}

}
