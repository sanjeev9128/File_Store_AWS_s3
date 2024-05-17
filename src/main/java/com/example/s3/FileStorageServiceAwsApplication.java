package com.example.s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@SpringBootApplication
public class FileStorageServiceAwsApplication {

	public static void main(String[] args) {
		
		/* String accessKey = "zBAM362R2tqtgy6leKN5qm7b02HeWG";
	        String secretKey = "XvcJODF4BdFG3jGOeyVNugLuJUPdu6";
	        String region = "us-east-1"; 

	        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
	        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                .withRegion(region)
	                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                .build();

	        
	        s3Client.listBuckets().forEach(bucket -> {
	            System.out.println("Bucket: " + bucket.getName());
	        });
		*/
		
		SpringApplication.run(FileStorageServiceAwsApplication.class, args);
	}

}
