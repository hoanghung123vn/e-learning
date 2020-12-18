package bean;

import enumeration.QuestionType;

public class Exercise {
	private int id;
	private String title;
	private String imagePath;
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
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
	private int checkedQuestion;
	private QuestionType type;
}
