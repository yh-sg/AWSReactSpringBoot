package reactSpringBoot.awsImageUpload.config;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;

@Configuration
public class AmazonConfig {
	
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(
					"","" 
				); //accessKey,SecretKeys
	}
	
}
