package com.example.feverwas.boundedContext.auth.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberIngredientSaveDto {
	private Long ingredientId;
	private LocalDate purchasedAt;
	private LocalDate expiresAt;
	private int quantity;
	private String type;
}
