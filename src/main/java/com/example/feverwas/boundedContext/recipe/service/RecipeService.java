package com.example.feverwas.boundedContext.recipe.service;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.auth.service.MemberService;
import com.example.feverwas.boundedContext.recipe.dto.RecipeSaveDto;
import com.example.feverwas.boundedContext.recipe.entity.Recipe;
import com.example.feverwas.boundedContext.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {
	private final RecipeRepository recipeRepository;
	private final MemberService memberService;

	public Recipe create(Long memberId, RecipeSaveDto recipeSaveDto) {
		Member member = memberService.read(memberId);
		Recipe recipe = Recipe.builder()
				.member(member)
				.title(recipeSaveDto.getTitle())
				.content(recipeSaveDto.getContent())
				.imageUrl(recipeSaveDto.getImageUrl())
				.build();

		return recipeRepository.save(recipe);
	}
}
