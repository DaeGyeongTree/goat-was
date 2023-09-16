package com.example.feverwas.boundedContext.recipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.ingredient.service.IngredientService;
import com.example.feverwas.boundedContext.recipe.entity.RecipeIngredient;
import com.example.feverwas.boundedContext.recipe.repository.RecipeIngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeIngredientService {
	private final RecipeIngredientRepository recipeIngredientRepository;
	private final RecipeService recipeService;
	private final IngredientService ingredientService;

	public RecipeIngredient create(Long recipeId, Long ingredientId) {
		RecipeIngredient recipeIngredient = RecipeIngredient.builder()
				.recipe(recipeService.read(recipeId))
				.ingredient(ingredientService.read(ingredientId))
				.build();
		return recipeIngredientRepository.save(recipeIngredient);
	}

	public List<RecipeIngredient> list(Long recipeId) {
		return recipeIngredientRepository.findAllByRecipeId(recipeId);
	}
}
