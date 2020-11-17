package com.burntcity.recipes.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CategoryTest {      // This is a Unit Test: No Spring Context

	Category category;
	
	@BeforeEach   // In JUnit 4 --> @Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}
}
