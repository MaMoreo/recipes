package com.burntcity.recipes.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.burntcity.recipes.domain.Difficulty;
import com.burntcity.recipes.domain.Ingredient;
import com.burntcity.recipes.domain.Recipe;
import com.burntcity.recipes.repositories.CategoryRepository;
import com.burntcity.recipes.repositories.RecipeRepository;
import com.burntcity.recipes.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * ApplicationListener is part of Spring Framework, while CommandLineRunner is
 * part of Spring Boot. Both can be used for the same thing. So if you have to
 * work on a Spring Framework application without Spring Boot, you will have to
 * use ApplicationListener.
 * 
 * Again, ContextRefreshedEvent is part of Spring Framework, while
 * ApplicationReadyEvent is Spring Boot specific. So if you want to keep your
 * code generic and not tied to Spring Boot, go with ContextRefreshedEvent.
 *
 */
@Slf4j
@Component
public class Bootstrap /* implements CommandLineRunner /* ApplicationListener<ContextRefreshedEvent> */ {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeRepository recipeRepository;

	public Bootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
			RecipeRepository recipeRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
	}

	/*@Override
	public void run(String... args) throws Exception {
		recipeRepository.saveAll(getRecipes());
	}*/

	// @Override
	// public void onApplicationEvent(ContextRefreshedEvent event) {
	// recipeRepository.saveAll(getRecipes());
	// }

	private List<Recipe> getRecipes() {

		List<Recipe> recipes = new ArrayList<>();

		Recipe guacamole = new Recipe();
		guacamole.setDescription("The best guacamole in Town!");
		guacamole.setCookTime(10);
		guacamole.setDirections("Blah Blah");
		guacamole.setServings(4);
		guacamole.setDifficulty(Difficulty.EASY);
		guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());

		Ingredient avocado = new Ingredient();
		avocado.setAmount(BigDecimal.valueOf(2));
		avocado.setDescription("ripe avocados");
		avocado.setUom(unitOfMeasureRepository.findByDescription("Each").get());

		Ingredient salt = new Ingredient();
		salt.setAmount(BigDecimal.valueOf(0.25));
		salt.setDescription("of salt, more to taste");
		salt.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());

		guacamole.addIngredient(avocado);
		guacamole.addIngredient(salt);

		recipes.add(guacamole);
		return recipes;
	}

}
