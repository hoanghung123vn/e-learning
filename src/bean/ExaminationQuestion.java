package bean;

public class ExaminationQuestion {
	private int id;
	private String paragraph;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correct;
	private String imagePath;
	private String audiomp3Path;
	private String audioggPath;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	private String question;
	private int no;
	private int examId;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParagraph() {
		return paragraph;
	}
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getAudiomp3Path() {
		return audiomp3Path;
	}
	public void setAudiomp3Path(String audiomp3Path) {
		this.audiomp3Path = audiomp3Path;
	}
	public String getAudioggPath() {
		return audioggPath;
	}
	public void setAudioggPath(String audioggPath) {
		this.audioggPath = audioggPath;
	}
}
