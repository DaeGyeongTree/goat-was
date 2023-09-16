package com.example.feverwas.boundedContext.recipe.entity;

import com.example.feverwas.base.entity.BaseEntity;
import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Recipe extends BaseEntity {
	private String title;
	private String content;
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@Builder
	public Recipe(String title, String content, String imageUrl, Member member) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.member = member;
	}
}
