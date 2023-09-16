package com.example.feverwas.boundedContext.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;
import com.example.feverwas.boundedContext.auth.repository.MemberIngredientRepository;
import com.example.feverwas.boundedContext.auth.service.MemberService;
import com.example.feverwas.boundedContext.auth.dto.MemberIngredientSaveDto;
import com.example.feverwas.boundedContext.ingredient.entity.Ingredient;
import com.example.feverwas.boundedContext.ingredient.service.IngredientService;

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
				.type(memberIngredientSaveDto.getType())
				.build();
		return memberIngredientRepository.save(memberIngredient);
	}

	public List<MemberIngredient> list(Long memberId, String category, String type) {
		Member member = memberService.read(memberId);

		return memberIngredientRepository.findAll().stream()
				.filter(memberIngredient -> {
					return memberIngredient.getMember().equals(member);
				})
				.filter(memberIngredient -> {
					if (category.equals(null)) {
						return true;
					} else {
						return memberIngredient.getIngredient().getIngredientCategory().getName().equals(category);
					}

				})
				.filter(memberIngredient -> {
					if (type.equals(null)) {
						return true;
					} else {
						return memberIngredient.getType().equals(type);
					}

				})
				.toList();
	}
}
