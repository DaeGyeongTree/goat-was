package com.example.feverwas.boundedContext.auth.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feverwas.base.jwt.dto.TokenDto;
import com.example.feverwas.boundedContext.auth.api.AuthApi;
import com.example.feverwas.boundedContext.auth.config.KakaoConfig;
import com.example.feverwas.boundedContext.auth.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
	private final AuthService authService;

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
	public void logout(HttpServletRequest request, HttpServletResponse response) {

	}
}
