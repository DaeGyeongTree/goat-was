package com.example.feverwas.base.oas;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(title = "피버톤",
				description = "피버톤 API 명세입니다.",
				version = "v1")
)
@Configuration
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi OpenApi() {
		String[] paths = {"/**"};

		return GroupedOpenApi.builder()
				.group("Tire, SO API v1")
				.pathsToMatch(paths)
				.build();
	}
}
