package reactSpringBoot.awsImageUpload.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reactSpringBoot.awsImageUpload.datastore.FakeUserProfileDataStore;

@Repository
public class UserProfileDataAccessService {
	private final FakeUserProfileDataStore fakeUserProfileDataStore;
	
	@Autowired
	public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDatastore) {
		this.fakeUserProfileDataStore = fakeUserProfileDatastore;
	}
	
	List<UsersProfile> getUsersProfiles(){
		return fakeUserProfileDataStore.getUserProfile();
	}
}
