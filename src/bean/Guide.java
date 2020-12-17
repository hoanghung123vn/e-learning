package bean;

import enumeration.GuideType;

public class Guide {
	private int id;
	private String imagePath;
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private GuideType guideType;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public GuideType getGuideType() {
		return guideType;
	}

	public void setGuideType(GuideType guideType) {
		this.guideType = guideType;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
