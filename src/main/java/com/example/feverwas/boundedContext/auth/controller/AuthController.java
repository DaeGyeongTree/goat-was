package com.example.feverwas.boundedContext.auth.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/sign-in/kakao/callback")
	public void kakaoLoginCallback() {
		authService.login();
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {

	}
}
