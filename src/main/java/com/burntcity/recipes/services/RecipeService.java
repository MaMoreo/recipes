package com.burntcity.recipes.services;

import java.util.Set;

import com.burntcity.recipes.domain.Recipe;

public interface RecipeService {
	public Set<Recipe> getRecipes();
}
