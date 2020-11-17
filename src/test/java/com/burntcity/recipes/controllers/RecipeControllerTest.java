package com.burntcity.recipes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.burntcity.recipes.domain.Recipe;
import com.burntcity.recipes.services.RecipeService;

class RecipeControllerTest {


	RecipeController controller;
	
	@Mock
	RecipeService recipeService;
	@Mock
	Model model;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(recipeService);
	}
	
	/**
	 * Tests Spring MVC with a mock dispatcher servlet
	 * This is STILL a Unit test. We are not starting Spring here 
	 * @throws Exception 
	 */
	@Test
	void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("index"));
				
	}
	
	@Test
	void testGetIndex() {
		assertEquals("index", controller.getIndex(model));
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), anySet());
	}
	
	@Test
	void testGetIndexBDT() {
		//given
		Set<Recipe> recipeData = new HashSet<>();
		recipeData.add(Recipe.builder().id(1L).build());
		recipeData.add(Recipe.builder().id(2L).build());
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		
		//when
		String viewName = controller.getIndex(model);
		
		//then
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> capturedSet = argumentCaptor.getValue();
		assertEquals(2, capturedSet.size());
	}

}
