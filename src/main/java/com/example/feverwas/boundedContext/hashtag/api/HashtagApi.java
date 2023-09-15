package com.example.feverwas.boundedContext.hashtag.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/hashtags")
@Tag(name = "Hashtag", description = "해시태그 관련 API")
public interface HashtagApi {
	@PostMapping
	@Operation(summary = "해시태그 생성", description = "해시태그를 생성하는 API 입니다.")
	ResponseEntity<String> createHashtag(@RequestBody String tag);
}
