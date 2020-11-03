package com.burntcity.recipes.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; // Needed by JPA
	
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	
	@Enumerated(value=EnumType.STRING)
	private Difficulty difficulty;
	
	@Lob    // Large Object (BLOB): tells the DB to store a BINARY larger than 255 chars.
	private Byte[] image;
	
	@OneToOne(cascade=CascadeType.ALL) // If a recipe is removed, remove its notes.
	private Notes notes;   
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients;
	
	@ManyToMany
	@JoinTable(name="recipe_category",  // the name of the table that will be created
		joinColumns = @JoinColumn(name="recipe_id"),  // the name of this column will be
		inverseJoinColumns = @JoinColumn(name="category_id")) // the name of this column will be
	private Set<Category> categories;
}
