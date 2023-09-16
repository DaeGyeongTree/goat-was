package com.example.feverwas.boundedContext.auth.api;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feverwas.base.jwt.dto.TokenDto;
import com.example.feverwas.boundedContext.auth.dto.MemberIngredientSaveDto;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/auth")
@Tag(name = "Auth", description = "사용자 인증 관련 API")
public interface AuthApi {
	@GetMapping("/login")
	@Operation(summary = "로그인 메서드", description = "카카오 로그인 페이지로 이동하기 위한 API 입니다.")
	void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException;

	@GetMapping("/login/callback")
	@Operation(summary = "로그인 메서드", description = "카카오 로그인이 실제 동작하는 메서드입니다. (API 호출 필요 없음)", hidden = true)
	ResponseEntity<TokenDto> kakaoLoginCallback(@RequestParam String code) throws IOException;

	@PostMapping("/logout")
	@Operation(summary = "로그아웃 메서드", description = "로그아웃을 하기 위한 메서드입니다.")
	ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	@PostMapping("/ingredients")
	@Operation(summary = "사용자 냉장고 재료 등록", description = "사용자 냉장고 재료를 등록하는 API 입니다.")
	ResponseEntity<String> saveIngredient(HttpServletRequest request, @RequestBody MemberIngredientSaveDto memberIngredientSaveDto);

	@GetMapping("/ingredients")
	@Operation(summary = "사용자 냉장고 재료 조회", description = "사용자 냉장고 재료를 조회하는 API 입니다.")
	ResponseEntity<List<MemberIngredient>> listIngredient(HttpServletRequest request, @RequestParam String category, @RequestParam String type);
}
