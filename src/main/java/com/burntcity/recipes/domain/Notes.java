package com.burntcity.recipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Needed by JPA

	@OneToOne // we do not need to specify a CASCADE, because Recipe owns this.
	private Recipe recipe; // If a note is removed, do not remove its recipe.
	
	@Lob    // Large Object (CLOB): tells the DB to store a STRING larger than 255 chars.
	private String recipeNotes;
}
