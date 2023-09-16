package com.example.feverwas.boundedContext.recipe.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
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

	public RecipeSaveDto(String title, String content, String imageUrl, Long[] integredientIdList) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.IntegredientIdList = integredientIdList;
	}
}
