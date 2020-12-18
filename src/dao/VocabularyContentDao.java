package dao;

import java.util.List;

import bean.VocabularyContent;

public interface VocabularyContentDao {
	List<VocabularyContent> findAll();
	
	List<VocabularyContent> findAllByGuideId(int guideId);
	
	void save(VocabularyContent vocabularyContent);
	
	int countById(int id);
}
