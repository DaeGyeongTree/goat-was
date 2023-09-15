package com.example.feverwas.boundedContext.ingredient.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/ingredients")
@Tag(name = "Ingredient", description = "재료 관련 API")
public interface IngredientApi {
	@GetMapping("/category")
	@Operation(summary = "재료 카테고리 조회", description = "재료 카테고리를 조회하는 API 입니다.")
	ResponseEntity<List<IngredientCategory>> getIngredientCategoryList();
}
