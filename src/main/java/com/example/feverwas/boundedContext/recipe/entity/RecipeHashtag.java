package com.example.feverwas.boundedContext.recipe.entity;

import com.example.feverwas.base.entity.BaseEntity;
import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.hashtag.entity.Hashtag;

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
public class RecipeHashtag extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;

	@ManyToOne
	@JoinColumn(name = "hashtag_id", nullable = false)
	private Hashtag hashtag;
}
