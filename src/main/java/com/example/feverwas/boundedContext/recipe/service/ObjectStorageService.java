package com.example.feverwas.boundedContext.recipe.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.feverwas.base.s3.config.S3Config;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectStorageService {
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	private final AmazonS3Client amazonS3Client;
	private final S3Config s3Config;

	public String upload(MultipartFile uploadFile, String fileName) throws IOException {
		String originalFileName = uploadFile.getOriginalFilename();
		String uploadFilePath =  "recipe/";
		String uploadFileName = getUUidFileName(originalFileName);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(uploadFile.getSize());
		metadata.setContentType(uploadFile.getContentType());

		String keyName = uploadFilePath + uploadFileName;    // example: "vouchers/uuid.jpg"
		InputStream inputStream = uploadFile.getInputStream();
		amazonS3Client.putObject(new PutObjectRequest(bucket, keyName, inputStream, metadata));
		return amazonS3Client.getUrl(bucket, keyName).toString();
	}

	private String getUUidFileName(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		return UUID.randomUUID().toString() + "." + ext;
	}
}
