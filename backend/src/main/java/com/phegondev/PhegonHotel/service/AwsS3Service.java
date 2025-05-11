package com.phegondev.PhegonHotel.service;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.phegondev.PhegonHotel.exception.OurException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class AwsS3Service {

    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public AwsS3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String saveImageToS3(MultipartFile photo) {
        try {
            String s3Filename = photo.getOriginalFilename();
            InputStream inputStream = photo.getInputStream();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpeg");

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3Filename, inputStream, metadata)
    .withCannedAcl(CannedAccessControlList.PublicRead);


            return "https://" + bucketName + ".s3.amazonaws.com/" + s3Filename;

        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to s3 bucket: " + e.getMessage());
        }
    }
}
















