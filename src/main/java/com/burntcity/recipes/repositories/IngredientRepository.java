package com.burntcity.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.recipes.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
