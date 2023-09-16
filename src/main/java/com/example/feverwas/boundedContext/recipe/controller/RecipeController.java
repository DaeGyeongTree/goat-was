package com.example.feverwas.boundedContext.recipe.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.feverwas.base.jwt.util.JwtProvider;
import com.example.feverwas.boundedContext.recipe.api.RecipeApi;
import com.example.feverwas.boundedContext.recipe.dto.RecipeSaveDto;
import com.example.feverwas.boundedContext.recipe.service.ObjectStorageService;
import com.example.feverwas.boundedContext.recipe.service.RecipeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController implements RecipeApi {
	private final ObjectStorageService objetcStorageService;
	private final JwtProvider jwtProvider;
	private final RecipeService recipeService;

	@Override
	public ResponseEntity<String> saveRecipeImage(@RequestPart("image_file") MultipartFile imageFile) throws IOException {
		return ResponseEntity.ok(objetcStorageService.upload(imageFile, imageFile.getName()));
	}

	@Override
	public ResponseEntity<String> saveRecipe(HttpServletRequest request, RecipeSaveDto recipeSaveDto) {
		Long memberId = jwtProvider.getUserId(jwtProvider.resolveToken(request).substring(7));
		recipeService.create(memberId, recipeSaveDto);
		return ResponseEntity.ok("레시피 등록 성공!");
	}
}
