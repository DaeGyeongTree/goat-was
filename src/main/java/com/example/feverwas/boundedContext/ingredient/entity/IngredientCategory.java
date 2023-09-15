package com.example.feverwas.boundedContext.ingredient.entity;

import com.example.feverwas.base.entity.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class IngredientCategory extends BaseEntity {
	private String name;

	@Builder
	public IngredientCategory(String name) {
		this.name = name;
	}
}
