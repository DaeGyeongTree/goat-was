package com.example.feverwas.boundedContext.recipe.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.feverwas.boundedContext.recipe.api.RecipeApi;
import com.example.feverwas.boundedContext.recipe.service.ObjectStorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController implements RecipeApi {
	private final ObjectStorageService objetcStorageService;

	@Override
	public ResponseEntity<String> saveRecipeImage(@RequestPart("image_file") MultipartFile imageFile) throws IOException {
		return ResponseEntity.ok(objetcStorageService.upload(imageFile, imageFile.getName()));
	}
}
