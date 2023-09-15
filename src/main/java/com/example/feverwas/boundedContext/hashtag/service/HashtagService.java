package com.example.feverwas.boundedContext.hashtag.service;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.hashtag.entity.Hashtag;
import com.example.feverwas.boundedContext.hashtag.repository.HashtagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashtagService {
	private final HashtagRepository hashtagRepository;

	public Hashtag create(String tag) {
		return hashtagRepository.save(Hashtag.builder().tag(tag).build());
	}
}
