package com.example.feverwas.boundedContext.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "kakao")
@Getter
@Setter
public class KakaoConfig {
	private String clientId;
	private String redirectUri;
	private String authorizationUri;
	private String tokenUri;
	private String userInfoUri;
}
