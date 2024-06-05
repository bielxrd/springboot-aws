package br.com.aws.study.s3.controller;

import br.com.aws.study.s3.dto.BucketPolicyRequest;
import br.com.aws.study.s3.service.S3Service;
import com.amazonaws.services.s3.model.Bucket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    private S3Service service;

    @PostMapping("/create")
    public ResponseEntity<Bucket> create(@RequestBody String bucketName) {
        System.out.println(bucketName);
        Bucket bucket = this.service.createBucket(bucketName);
        return ResponseEntity.ok().body(bucket);
    }

    @PostMapping("/put")
    public ResponseEntity<Object> putObjects(@RequestBody String bucketName) {
        String keyCatImage = "cat.jpg";
        String keyIndexHtml = "index.html";

        service.putObjects(bucketName, keyCatImage, new File("D:\\Git\\Studying AWS Services\\Studying-AWS-Services\\src\\main\\resources\\templates\\cat.jpg"));
        service.putObjects(bucketName, keyIndexHtml, new File("D:\\Git\\Studying AWS Services\\Studying-AWS-Services\\src\\main\\resources\\templates\\index.html"));
        return ResponseEntity.ok().body("Objetos colocados no bucket com sucesso");
    }

    @PostMapping("/policy")
    public ResponseEntity<Object> putBucketPolicy(@RequestBody BucketPolicyRequest request) throws JsonProcessingException {
        String bucketName = request.getBucketName();

        ObjectMapper mapper = new ObjectMapper();
        String policyJson;

        policyJson = mapper.writeValueAsString(request.getPolicy());

        this.service.putBucketPolicy(bucketName, policyJson);

        return ResponseEntity.ok().body("Politica atualizada com sucesso");
    }

}
