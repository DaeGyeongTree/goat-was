package com.example.feverwas.boundedContext.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.recipe.entity.RecipeHashtag;

public interface RecipeHashtagRepository extends JpaRepository<RecipeHashtag, Long> {
}
