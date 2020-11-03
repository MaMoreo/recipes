package com.burntcity.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.recipes.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
