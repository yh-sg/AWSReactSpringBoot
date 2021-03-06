package reactSpringBoot.awsImageUpload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-profile")
public class UserProfile {
	
	@Value("${env.EXAMPLE_NAME}")
	String name;
	
	@GetMapping
	public String getUserProfile() {
		return name;
	}
}
