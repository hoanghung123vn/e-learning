package bean;

public class Examination {
	private int id;
	private String title;
	private String imagePath;
	private int checkedQuestion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getCheckedQuestion() {
		return checkedQuestion;
	}
	public void setCheckedQuestion(int checkedQuestion) {
		this.checkedQuestion = checkedQuestion;
	}
}
