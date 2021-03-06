package reactSpringBoot.awsImageUpload.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UsersProfile {
	private final UUID userId;
	private final String userName;
	private String userProfileImageLink; //S3 key
	
	public UsersProfile(UUID userId, String userName, String userProfileImageLink) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userProfileImageLink = userProfileImageLink;
	}

	public UUID getuserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public Optional<String> getUserProfileImageLink() {
		return Optional.ofNullable(userProfileImageLink);
	}

	public void setUserProfileImageLink(String userProfileImageLink) {
		this.userProfileImageLink = userProfileImageLink;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (!(obj instanceof UsersProfile)) return false;
		
		UsersProfile other = (UsersProfile) obj;
		
		return Objects.equals(userId, other.userId) && 
				Objects.equals(userName, other.userName) &&
				Objects.equals(userProfileImageLink, other.userProfileImageLink);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, userProfileImageLink);
	}
	
	
}
