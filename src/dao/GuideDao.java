package dao;

import java.util.List;

import bean.Guide;
import enumeration.GuideType;

public interface GuideDao {
	List<Guide> findAll(int pageId, int count, GuideType guideType);
	
	Guide getById(int guideId);
	
	int count(GuideType guideType);
	
	boolean updateContent(String content, int guideId);
	
	boolean insertGuide(Guide guide);
	
	List<Guide> findByTitle(String title);
	
	void delete(int id);
}
