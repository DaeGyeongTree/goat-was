package com.example.feverwas.boundedContext.ingredient.entity;

import com.example.feverwas.base.entity.BaseEntity;

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
public class Ingredient extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "ingredient_category_id", nullable = false)
	private IngredientCategory ingredientCategory;

	private String name;
}
