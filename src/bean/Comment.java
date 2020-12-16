package bean;

public class Comment {
	private int id;
	
	private String contentString;
	
	private int userId;
	
	private int guideId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContentString() {
		return contentString;
	}
	
	public void setContentString(String contentString) {
		this.contentString = contentString;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getGuideId() {
		return guideId;
	}
	
	public Comment(String contentString, int userId, int guideId) {
		this.contentString = contentString;
		this.userId = userId;
		this.guideId = guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}
	
}
