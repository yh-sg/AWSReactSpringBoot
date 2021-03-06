package reactSpringBoot.awsImageUpload.bucket;

public enum BucketName {
	
	PROFILE_IMAGE("reactsbawsimage");
	
	private final String bucketName;
	
	BucketName(String bucketName){
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}
	
	
}
