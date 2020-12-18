package bean;

public class Comment {
	private int id;

	public Comment() {
	}

	private String content;
	
	private int userId;
	
	private int guideId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
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
	
	public Comment(String content, int userId, int guideId) {
		this.content = content;
		this.userId = userId;
		this.guideId = guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}
	
}
