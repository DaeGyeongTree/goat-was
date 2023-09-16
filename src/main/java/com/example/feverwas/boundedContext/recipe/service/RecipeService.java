package com.example.feverwas.boundedContext.recipe.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;
import com.example.feverwas.boundedContext.auth.service.MemberIngredientService;
import com.example.feverwas.boundedContext.auth.service.MemberService;
import com.example.feverwas.boundedContext.recipe.dto.RecipeSaveDto;
import com.example.feverwas.boundedContext.recipe.entity.Recipe;
import com.example.feverwas.boundedContext.recipe.repository.RecipeIngredientRepository;
import com.example.feverwas.boundedContext.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {
	private final RecipeRepository recipeRepository;
	private final MemberService memberService;
	private final MemberIngredientService memberIngredientService;
	private final RecipeIngredientService recipeIngredientService;

	public Recipe create(Long memberId, RecipeSaveDto recipeSaveDto) {
		Member member = memberService.read(memberId);
		Recipe recipe = Recipe.builder()
				.member(member)
				.title(recipeSaveDto.getTitle())
				.content(recipeSaveDto.getContent())
				.imageUrl(recipeSaveDto.getImageUrl())
				.build();

		Arrays.stream(recipeSaveDto.getIntegredientIdList()).toList().forEach(ingredientId -> {
			recipeIngredientService.create(recipe.getId(), ingredientId);
		});

		return recipeRepository.save(recipe);
	}

	public List<Recipe> list() {
		return recipeRepository.findAll();
	}

	public List<Recipe> recommendList(Long memberId) {
		Member member = memberService.read(memberId);
		List<MemberIngredient> memberIngredientList = memberIngredientService.list(memberId);
		List<Recipe> recipeList = recipeRepository.findAll();
		return recipeRepository.findAll();
	}

	public Recipe read(Long recipeId) {
		return recipeRepository.findById(recipeId).orElseThrow();
	}
}
