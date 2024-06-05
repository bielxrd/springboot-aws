package br.com.aws.study.s3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BucketPolicyRequest {
    private String bucketName;
    private Map<String, Object> policy;
}
