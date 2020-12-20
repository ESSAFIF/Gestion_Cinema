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


    private String accessKey = "tK8Z9ZCelbUI2YiCnn7We6ZUusTB/rjyHZvRTf3P";

    private String awsKeyId = "AKIAXIVLTVYM2ZU3B5GP";
    private String region="eu-west-3";
    private String  bucketName="photocine";
    private String contentType="text/html";

	@Override
	public URL  savePhoto(InputStream photo, String title) throws Exception  {
  	  BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, accessKey);
	  
  	  AmazonS3 amazonS3Client= AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
              .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

  	     String file_name = "img_SOME_LOGIC.jpg";
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpeg" );
        objectMetadata.setContentEncoding("UTF-8");
        long size = photo.available();
        objectMetadata.setContentLength(size);
        
      
        //TODO add cache control
        try {
            amazonS3Client.putObject(bucketName, file_name,photo, objectMetadata);
          
           
        } catch (AmazonClientException e) {
            e.printStackTrace();
        }
        return amazonS3Client.getUrl(bucketName, title);
      
    }

  

}
