package reactSpringBoot.awsImageUpload.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-profile")
public class UserProfileController {
	
	private final UserProfileService userProfileService;
	
	@Autowired
	public UserProfileController(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	
	@GetMapping
	public List<UsersProfile> getUserProfiles(){
		return userProfileService.getUsersProfiles();
	}
	
	
}
