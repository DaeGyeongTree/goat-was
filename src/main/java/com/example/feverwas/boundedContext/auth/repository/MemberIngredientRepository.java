package com.example.feverwas.boundedContext.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;

public interface MemberIngredientRepository extends JpaRepository<MemberIngredient, Long> {
}
