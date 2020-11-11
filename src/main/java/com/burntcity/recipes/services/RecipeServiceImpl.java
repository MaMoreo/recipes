package com.burntcity.recipes.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.burntcity.recipes.domain.Recipe;
import com.burntcity.recipes.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository repository;

	public RecipeServiceImpl(RecipeRepository repository) {
		super();
		this.repository = repository;
	}

	public Set<Recipe> getRecipes() {
		log.debug("Find all recipes");
		Set<Recipe> result = new HashSet<>();
		repository.findAll().iterator().forEachRemaining(result::add);
		return result;
	}
}
