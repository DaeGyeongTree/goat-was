package com.example.feverwas.boundedContext.ingredient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;
import com.example.feverwas.boundedContext.ingredient.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientService {
	private final IngredientRepository ingredientRepository;

	public List<Ingredient> list() {
		return ingredientRepository.findAll();
	}

	public List<Ingredient> list(Long categoryId) {
		return ingredientRepository.findAll().stream().filter(ingredient -> ingredient.getIngredientCategory().getId().equals(categoryId)).toList();
	}
}
