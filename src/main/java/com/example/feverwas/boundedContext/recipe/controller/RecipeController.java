package com.example.feverwas.boundedContext.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.feverwas.base.jwt.util.JwtProvider;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;
import com.example.feverwas.boundedContext.auth.service.MemberIngredientService;
import com.example.feverwas.boundedContext.recipe.api.RecipeApi;
import com.example.feverwas.boundedContext.recipe.dto.RecipeSaveDto;
import com.example.feverwas.boundedContext.recipe.entity.Recipe;
import com.example.feverwas.boundedContext.recipe.entity.RecipeIngredient;
import com.example.feverwas.boundedContext.recipe.service.ObjectStorageService;
import com.example.feverwas.boundedContext.recipe.service.RecipeIngredientService;
import com.example.feverwas.boundedContext.recipe.service.RecipeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController implements RecipeApi {
	private final ObjectStorageService objetcStorageService;
	private final JwtProvider jwtProvider;
	private final RecipeService recipeService;
	private final MemberIngredientService memberIngredientService;
	private final RecipeIngredientService recipeIngredientService;

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

	@Override
	public ResponseEntity<List<Recipe>> listRecipe() {
		return ResponseEntity.ok(recipeService.list());
	}

	@Override
	public ResponseEntity<List<Recipe>> listRecommendRecipe(HttpServletRequest request) {
		Long memberId = jwtProvider.getUserId(jwtProvider.resolveToken(request).substring(7));
		List<MemberIngredient> memberIngredientList = memberIngredientService.list(memberId);
		List<Recipe> recipeList = recipeService.list().stream()
				.filter(recipe ->
					recipeIngredientService.list(recipe.getId()).stream()
							.map(RecipeIngredient::getIngredient)
							.collect(Collectors.toList())
							.containsAll(memberIngredientList.stream()
									.map(MemberIngredient::getIngredient)
									.collect(Collectors.toList())))
				.collect(Collectors.toList());

		return ResponseEntity.ok(recipeList);
	}

	@Override
	public ResponseEntity<Recipe> readRecipe(HttpServletRequest request, @PathVariable Long recipeId) {
		return ResponseEntity.ok(recipeService.read(recipeId));
	}
}
