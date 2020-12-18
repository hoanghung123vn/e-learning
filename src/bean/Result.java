package bean;

import java.sql.Timestamp;

public class Result {
	private int id;
	private int sumReadCorrect;
	private int sumListenCorrect;
	private int sumIncorrect;
	private Timestamp timestamp;
	private int userId;
	private int examId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSumReadCorrect() {
		return sumReadCorrect;
	}
	public void setSumReadCorrect(int sumReadCorrect) {
		this.sumReadCorrect = sumReadCorrect;
	}
	public int getSumListenCorrect() {
		return sumListenCorrect;
	}
	public void setSumListenCorrect(int sumListenCorrect) {
		this.sumListenCorrect = sumListenCorrect;
	}
	public int getSumIncorrect() {
		return sumIncorrect;
	}
	public void setSumIncorrect(int sumIncorrect) {
		this.sumIncorrect = sumIncorrect;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
