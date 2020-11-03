package com.burntcity.recipes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.recipes.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);
}
