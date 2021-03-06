package reactSpringBoot.awsImageUpload.profile;

import static org.apache.http.entity.ContentType.IMAGE_GIF;
import static org.apache.http.entity.ContentType.IMAGE_JPEG;
import static org.apache.http.entity.ContentType.IMAGE_PNG;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import reactSpringBoot.awsImageUpload.bucket.BucketName;
import reactSpringBoot.awsImageUpload.filestore.FileStore;

@Service
public class UserProfileService {
	private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;
	
    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }
	
	List<UsersProfile> getUsersProfiles(){
		return userProfileDataAccessService.getUsersProfiles();
	}

	public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
		//1. check if image is not empty
		if(file.isEmpty()) throw new IllegalStateException("File is empty...");
		
		//2. if file is not an image
		if(!Arrays.asList(
				IMAGE_JPEG.getMimeType(),
				IMAGE_PNG.getMimeType(),
				IMAGE_GIF.getMimeType()).contains(file.getContentType())) 
			throw new IllegalStateException("File must be an image ->" + file.getContentType());
		
		//3. The user exist in database or not!
		UsersProfile user = getUserProfileOrThrow(userProfileId);
		
		//4.Grab some metadata from file if any
		Map<String, String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		
		//5. Store the image in s3 and update database with s3 image link
		String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getuserId());
		String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
		try {
			fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
			user.setUserProfileImageLink(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] downloadUserProfileImage(UUID userProfileId) {
		UsersProfile user = getUserProfileOrThrow(userProfileId);
		String path = String.format("%s/%s", 
				BucketName.PROFILE_IMAGE.getBucketName(), 
				user.getuserId());
		
		return user.getUserProfileImageLink()
			.map(key->fileStore.download(path, key))
			.orElse(new byte[0]);
	}
	
	private UsersProfile getUserProfileOrThrow(UUID userProfileId) {
		return userProfileDataAccessService.getUsersProfiles()
				.stream()
				.filter(userProfile-> userProfile.getuserId().equals(userProfileId))
				.findFirst()
				.orElseThrow(()->new IllegalStateException(String.format("User profile %s is not found", userProfileId)));
	}
	
}
