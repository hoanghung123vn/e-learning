package bean;

public class VocabularyContent {
	private int id;
	private int num;
	private String transcribe;
	private String title;
	private String imagePath;
	private String audiomp3Path;	
	private String audioggPath;
	private String mean;
	private int guideId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTranscribe() {
		return transcribe;
	}
	public void setTranscribe(String transcribe) {
		this.transcribe = transcribe;
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
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public int getGuideId() {
		return guideId;
	}
	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}
}
