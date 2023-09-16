package com.example.feverwas.boundedContext.ingredient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feverwas.base.jwt.util.JwtProvider;
import com.example.feverwas.boundedContext.ingredient.api.IngredientApi;
import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;
import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;
import com.example.feverwas.boundedContext.ingredient.service.IngredientCategoryService;
import com.example.feverwas.boundedContext.ingredient.service.IngredientService;
import com.example.feverwas.boundedContext.auth.service.MemberIngredientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IngredientController implements IngredientApi {
	private final IngredientCategoryService ingredientCategoryService;
	private final IngredientService ingredientService;
	private final MemberIngredientService memberIngredientService;
	private final JwtProvider jwtProvider;

	@Override
	public ResponseEntity<List<IngredientCategory>> getIngredientCategoryList() {
		return ResponseEntity.ok(ingredientCategoryService.list());
	}

	@Override
	public ResponseEntity<List<Ingredient>> getIngredientListByCategory(@RequestParam(required = true, name = "category") Long categoryId) {
		return ResponseEntity.ok(ingredientService.list(categoryId));
	}
}
