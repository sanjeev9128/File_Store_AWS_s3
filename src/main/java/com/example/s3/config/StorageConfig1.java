package com.example.s3.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazonaws.services.s3.model.ServerSideEncryptionByDefault;
import com.amazonaws.services.s3.model.ServerSideEncryptionConfiguration;
import com.amazonaws.services.s3.model.ServerSideEncryptionRule;
import com.amazonaws.services.s3.model.SetBucketEncryptionRequest;
@Configuration
public class StorageConfig1 {
	@Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecret;
    @Value("${cloud.aws.region.static}")
    private String region;
	
 @Bean
	public AmazonS3 s3Client() {
	AmazonS3 s3client = AmazonS3ClientBuilder.standard()
		.withRegion(Regions.DEFAULT_REGION)
		.build();
			 
			ServerSideEncryptionByDefault serverSideEncryptionByDefault = new ServerSideEncryptionByDefault()
			 .withSSEAlgorithm(SSEAlgorithm.KMS);
			ServerSideEncryptionRule rule = new ServerSideEncryptionRule()
			 .withApplyServerSideEncryptionByDefault(serverSideEncryptionByDefault);
			 //.withBucketKeyEnabled(true);
			ServerSideEncryptionConfiguration serverSideEncryptionConfiguration =
			 new ServerSideEncryptionConfiguration().withRules(Collections.singleton(rule));

			SetBucketEncryptionRequest setBucketEncryptionRequest = new SetBucketEncryptionRequest()
			 .withServerSideEncryptionConfiguration(serverSideEncryptionConfiguration)
			 .withBucketName("test787345");
			
			 s3client.setBucketEncryption(setBucketEncryptionRequest);
			 return null;
	}
}
