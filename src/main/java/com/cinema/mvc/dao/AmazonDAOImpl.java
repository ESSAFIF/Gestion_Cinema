package com.cinema.mvc.dao;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.web.multipart.MultipartFile;

public class AmazonDAOImpl implements  AmazonDAO{


    private String accessKey = "7c3HDM7Rkvcp57FDAzwTx8jl/tUtWHOw2TEZIbi6";

    private String awsKeyId = "AKIAJMNTE2JK2DDQMM7Q";
    private String region="eu-west-3";
    private String  bucketName="photocine";
    private String contentType="image/jpeg";

	@Override
	public URL  savePhoto(InputStream photo, String title) throws Exception  {
  	  BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, accessKey);
	  
  	  AmazonS3 amazonS3Client= AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
              .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

    	
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(contentType);
    
        
        //TODO add cache control
        try {
            amazonS3Client.putObject(bucketName, title,photo, objectMetadata);
          
            
        } catch (AmazonClientException e) {
            e.printStackTrace();
        }
        return amazonS3Client.getUrl(bucketName, title);
      
    }

  

}
