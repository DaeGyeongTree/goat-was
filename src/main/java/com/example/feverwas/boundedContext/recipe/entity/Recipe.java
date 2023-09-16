package com.example.feverwas.boundedContext.recipe.entity;

import java.util.List;

import com.example.feverwas.base.entity.BaseEntity;
import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.ingredient.entity.IngredientCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@Column(columnDefinition = "TEXT")
	private String content;
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredient;

	@Builder
	public Recipe(String title, String content, String imageUrl, Member member) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.member = member;
	}
}
