package com.burntcity.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.recipes.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
