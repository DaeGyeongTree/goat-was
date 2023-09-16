package com.example.feverwas.boundedContext.recipe.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RecipeSaveDto {
	private String title;
	private String content;
	private String imageUrl;
	private Long[] IntegredientIdList;
	private String difficulty;
	private String cookingTime;
	private String serving;

	@Builder
	public RecipeSaveDto(String title, String content, String imageUrl, Long[] IntegredientIdList, String difficulty,
			String cookingTime, String serving) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.IntegredientIdList = IntegredientIdList;
		this.difficulty = difficulty;
		this.cookingTime = cookingTime;
		this.serving = serving;
	}
}
