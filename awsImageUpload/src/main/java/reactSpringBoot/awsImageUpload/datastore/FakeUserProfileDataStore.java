package reactSpringBoot.awsImageUpload.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactSpringBoot.awsImageUpload.profile.UsersProfile;

@Repository
public class FakeUserProfileDataStore {
	private static final List<UsersProfile> USER_PROFILES = new ArrayList<>();
	
	static {
		USER_PROFILES.add(new UsersProfile(UUID.randomUUID(),"Kasumi", null));
		USER_PROFILES.add(new UsersProfile(UUID.randomUUID(),"Shiori", null));
		USER_PROFILES.add(new UsersProfile(UUID.randomUUID(),"Yui", null));
	}
	
	public List<UsersProfile> getUserProfile(){
		return USER_PROFILES;
	}
}
