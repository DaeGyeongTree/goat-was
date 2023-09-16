package com.example.feverwas.boundedContext.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.recipe.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
	List<RecipeIngredient> findAllByRecipeId(Long recipeId);
}
