package com.burntcity.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@RequestMapping({"", "/", "index", "index.html"})
	public String getIndex() {
		return "index";
	}
	
}
