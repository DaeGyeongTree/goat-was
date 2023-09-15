package com.example.feverwas.boundedContext.ingredient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;
import com.example.feverwas.boundedContext.ingredient.repository.IngredientCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientCategoryService {
	private final IngredientCategoryRepository ingredientCategoryRepository;

	public List<IngredientCategory> list() {
		return ingredientCategoryRepository.findAll();
	}
}
