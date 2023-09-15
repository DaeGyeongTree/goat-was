package com.example.feverwas.boundedContext.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
