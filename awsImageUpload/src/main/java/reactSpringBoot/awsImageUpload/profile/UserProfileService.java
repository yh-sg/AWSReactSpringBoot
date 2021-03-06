package reactSpringBoot.awsImageUpload.profile;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserProfileService {
	private final UserProfileDataAccessService userProfileDataAccessService;
	
	@Autowired
	public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
		this.userProfileDataAccessService = userProfileDataAccessService;	
	}
	
	List<UsersProfile> getUsersProfiles(){
		return userProfileDataAccessService.getUsersProfiles();
	}

	public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
		//1. check if image is not empty
		
		//2. if file is an image
		
		//3. The user exist in database or not!
		
		//4.Grab some metadata from file if any
		
		//5. Store the image in s3 and update database with s3 image link
	}
}
