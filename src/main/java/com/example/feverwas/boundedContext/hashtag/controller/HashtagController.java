package com.example.feverwas.boundedContext.hashtag.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.feverwas.boundedContext.hashtag.api.HashtagApi;
import com.example.feverwas.boundedContext.hashtag.service.HashtagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HashtagController implements HashtagApi {
	private final HashtagService hashtagService;

	@Override
	public ResponseEntity<String> createHashtag(String tag) {
		return ResponseEntity.ok(hashtagService.create(tag).getTag() + " 해시태그 생성 완료"
	}
}
