package com.example.feverwas.boundedContext.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.feverwas.boundedContext.auth.config.KakaoConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoService {
	private final KakaoConfig kakaoConfig;

	public String getAuthorizationUrl() {
		return UriComponentsBuilder
				.fromUriString(kakaoConfig.getAuthorizationUri())
				.queryParam("client_id", kakaoConfig.getClientId())
				.queryParam("redirect_uri", kakaoConfig.getRedirectUri())
				.queryParam("response_type", "code")
				.build()
				.toString();
	}
}
