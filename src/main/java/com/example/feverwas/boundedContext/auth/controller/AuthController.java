package com.example.feverwas.boundedContext.auth.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feverwas.base.jwt.dto.TokenDto;
import com.example.feverwas.base.jwt.util.JwtProvider;
import com.example.feverwas.boundedContext.auth.api.AuthApi;
import com.example.feverwas.boundedContext.auth.entity.MemberIngredient;
import com.example.feverwas.boundedContext.auth.service.AuthService;
import com.example.feverwas.boundedContext.auth.dto.MemberIngredientSaveDto;
import com.example.feverwas.boundedContext.auth.service.MemberIngredientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
	private final AuthService authService;
	private final MemberIngredientService memberIngredientService;
	private final JwtProvider jwtProvider;

	@Override
	public void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(authService.getAuthorizationUrl());
	}

	@Override
	public ResponseEntity<TokenDto> kakaoLoginCallback(@RequestParam String code) throws MalformedURLException {
		TokenDto tokenDto = authService.login(code);
		return ResponseEntity.ok(tokenDto);
	}

	@Override
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		authService.logout(request, response);
		return ResponseEntity.ok("로그아웃 성공");
	}

	@Override
	public ResponseEntity<String> saveIngredient(HttpServletRequest request, @RequestBody MemberIngredientSaveDto memberIngredientSaveDto) {
		Long memberId = jwtProvider.getUserId(jwtProvider.resolveToken(request).substring(7));
		memberIngredientService.create(memberId, memberIngredientSaveDto);
		return ResponseEntity.ok("재료 등록 성공");
	}

	@Override
	public ResponseEntity<List<MemberIngredient>> listIngredient(HttpServletRequest request, @RequestParam String category, @RequestParam String type) {
		Long memberId = jwtProvider.getUserId(jwtProvider.resolveToken(request).substring(7));
		return ResponseEntity.ok(memberIngredientService.list(memberId, category, type));
	}
}
