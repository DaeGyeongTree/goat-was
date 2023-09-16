package com.example.feverwas.boundedContext.ingredient.service;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;
import com.example.feverwas.boundedContext.auth.repository.MemberIngredientRepository;
import com.example.feverwas.boundedContext.auth.service.MemberService;
import com.example.feverwas.boundedContext.ingredient.dto.MemberIngredientSaveDto;
import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberIngredientService {
	private final MemberIngredientRepository memberIngredientRepository;
	private final IngredientService ingredientService;
	private final MemberService memberService;

	public MemberIngredient create(Long memberId, MemberIngredientSaveDto memberIngredientSaveDto) {
		Member member = memberService.read(memberId);
		Ingredient ingredient = ingredientService.read(memberIngredientSaveDto.getIngredientId());
		MemberIngredient memberIngredient = MemberIngredient.builder()
				.member(member)
				.ingredient(ingredient)
				.purchasedAt(memberIngredientSaveDto.getPurchasedAt())
				.expiresAt(memberIngredientSaveDto.getExpiresAt())
				.quantity(memberIngredientSaveDto.getQuantity())
				.build();
		return memberIngredientRepository.save(memberIngredient);
	}
}
