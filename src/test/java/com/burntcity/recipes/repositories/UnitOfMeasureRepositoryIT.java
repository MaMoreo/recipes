package com.burntcity.recipes.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.burntcity.recipes.domain.UnitOfMeasure;

/**
 * Integration Test
 * @author midga
 *
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest                       // Brings an embedded DB, configures Spring Data JPA
class UnitOfMeasureRepositoryIT {

	@Autowired                      // We can do this because its a IT
	UnitOfMeasureRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindByDescription() {
		Optional<UnitOfMeasure> uomOptional = repository.findByDescription("Tablespoon");
		assertEquals("Tablespoon", uomOptional.get().getDescription());
	}

}
