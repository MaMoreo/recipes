package com.burntcity.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burntcity.recipes.services.RecipeService;

@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
		return "recipe/show";
	}
	
}
