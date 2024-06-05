package br.com.aws.study.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class S3Service {

    @Autowired
    private AmazonS3 amazonS3;

    public Bucket createBucket(String bucketName) {
        return amazonS3.createBucket(bucketName);
    }

    public PutObjectResult putObjects(String bucketName, String key, File file) {
        try {
            return amazonS3.putObject(new PutObjectRequest(bucketName, key, file));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putBucketPolicy(String bucketName, String policy) {
        try {
            amazonS3.setBucketPolicy(new SetBucketPolicyRequest(bucketName, policy));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
