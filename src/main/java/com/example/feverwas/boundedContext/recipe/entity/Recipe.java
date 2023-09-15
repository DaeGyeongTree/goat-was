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
	private String image_url;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@Builder
	public Recipe(String title, String content, String image_url, Member member) {
		this.title = title;
		this.content = content;
		this.image_url = image_url;
		this.member = member;
	}
}
