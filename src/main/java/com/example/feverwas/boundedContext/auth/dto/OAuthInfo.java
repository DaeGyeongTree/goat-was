package com.example.feverwas.boundedContext.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthInfo {
	private String id;
	private String email;
	private String nickname;

	@Builder
	public OAuthInfo(String id, String email, String nickname) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
	}
}
