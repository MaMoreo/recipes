package com.burntcity.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burntcity.recipes.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "index", "index.html" })
	public String getIndex(Model model) {
		log.debug("GET call all Recipes");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
