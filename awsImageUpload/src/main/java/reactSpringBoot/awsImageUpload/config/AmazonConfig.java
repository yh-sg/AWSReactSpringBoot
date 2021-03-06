package reactSpringBoot.awsImageUpload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
	@Value("${AWSAccessKeyId}")
	String accesskeyId;
	@Value("${AWSSecretKey}")
	String secretkey;
	@Value("${AWSRegion}")
	String region;

	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(
				accesskeyId,secretkey
				);
		return AmazonS3ClientBuilder
					.standard()
					.withRegion(region)
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
					.build();
	}
	
}
