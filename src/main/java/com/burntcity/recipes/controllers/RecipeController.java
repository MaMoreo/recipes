package com.burntcity.recipes.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burntcity.recipes.domain.Category;
import com.burntcity.recipes.domain.UnitOfMeasure;
import com.burntcity.recipes.repositories.CategoryRepository;
import com.burntcity.recipes.repositories.UnitOfMeasureRepository;

@Controller
public class RecipeController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	
	
	public RecipeController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"", "/", "index", "index.html"})
	public String getIndex() {
		
		Optional<Category> optionalCat = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> optionalUnitOfMes = unitOfMeasureRepository.findByDescription("Tablespoon");
		
		System.out.println("Cat ID is " + optionalCat.get().getId());
		System.out.println("UOM ID is " + optionalUnitOfMes.get().getId());
		
		return "index";
	}
	
}
