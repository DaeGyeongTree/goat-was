package com.example.feverwas.boundedContext.ingredient.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feverwas.boundedContext.ingredient.dto.MemberIngredientSaveDto;
import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;
import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/ingredients")
@Tag(name = "Ingredient", description = "재료 관련 API")
public interface IngredientApi {
	@GetMapping("/category")
	@Operation(summary = "재료 카테고리 조회", description = "재료 카테고리를 조회하는 API 입니다.")
	ResponseEntity<List<IngredientCategory>> getIngredientCategoryList();

	@GetMapping
	@Operation(summary = "카테고리별 재료 조회", description = "카테고리별 재료를 조회하는 API 입니다.")
	ResponseEntity<List<Ingredient>> getIngredientListByCategory(@RequestParam(required = true, name = "category") Long categoryId);

	@PostMapping
	@Operation(summary = "사용자 냉장고 재료 등록", description = "사용자 냉장고 재료를 등록하는 API 입니다.")
	ResponseEntity<String> saveIngredient(HttpServletRequest request, @RequestBody MemberIngredientSaveDto memberIngredientSaveDto);
}
