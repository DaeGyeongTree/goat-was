package com.example.feverwas.boundedContext.recipe.api;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/recipes")
@Tag(name = "Recipe", description = "레시피 관련 API")
public interface RecipeApi {
	@PostMapping("/image")
	@Operation(summary = "레시피 이미지 등록", description = "레시피 이미지를 등록하는 API 입니다.")
	ResponseEntity<String> saveRecipeImage(@RequestPart("image_file") MultipartFile imageFile) throws IOException;
}
