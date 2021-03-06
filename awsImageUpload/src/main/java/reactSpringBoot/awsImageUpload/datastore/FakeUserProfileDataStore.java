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
//		USER_PROFILES.add(new UsersProfile(UUID.randomUUID(),"Kasumi", null));
		USER_PROFILES.add(new UsersProfile(UUID.fromString("371c7433-6446-4b44-984b-b7a1c9f7e315"),"Kasumi", null));
		USER_PROFILES.add(new UsersProfile(UUID.fromString("ac1669c4-5abb-4070-abc2-020311fe8868"),"Shiori", null));
		USER_PROFILES.add(new UsersProfile(UUID.fromString("06cf6913-c76c-4011-89d0-ab0fcd31197e"),"Yui", null));

	}
	
	public List<UsersProfile> getUserProfile(){
		return USER_PROFILES;
	}
}
