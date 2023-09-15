package com.example.feverwas.boundedContext.ingredient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.feverwas.boundedContext.ingredient.api.IngredientApi;
import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;
import com.example.feverwas.boundedContext.ingredient.service.IngredientCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class IngredientController implements IngredientApi {
	private final IngredientCategoryService ingredientCategoryService;

	@Override
	public ResponseEntity<List<IngredientCategory>> getIngredientCategoryList() {
		return ResponseEntity.ok(ingredientCategoryService.list());
	}
}
