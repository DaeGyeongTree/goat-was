package com.example.feverwas.boundedContext.recipe.api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.feverwas.boundedContext.recipe.dto.RecipeSaveDto;
import com.example.feverwas.boundedContext.recipe.entity.Recipe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/recipes")
@Tag(name = "Recipe", description = "레시피 관련 API")
public interface RecipeApi {
	@PostMapping("/image")
	@Operation(summary = "레시피 이미지 등록", description = "레시피 이미지를 등록하는 API 입니다.")
	ResponseEntity<String> saveRecipeImage(@RequestPart("image_file") MultipartFile imageFile) throws IOException;

	@PostMapping
	@Operation(summary = "레시피 등록", description = "레시피를 등록하는 API 입니다.")
	ResponseEntity<String> saveRecipe(HttpServletRequest request, @RequestBody RecipeSaveDto recipeSaveDto);

	@GetMapping
	@Operation(summary = "레시피 조회", description = "레시피를 조회하는 API 입니다.")
	ResponseEntity<List<Recipe>> listRecipe();
}
