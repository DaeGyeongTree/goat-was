package com.example.feverwas.boundedContext.auth.entity;

import java.time.LocalDate;

import com.example.feverwas.base.entity.BaseEntity;
import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MemberIngredient extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "ingredient_id", nullable = false)
	private Ingredient ingredient;

	private LocalDate purchasedAt;

	private LocalDate expiresAt;

	private int quantity;

}
