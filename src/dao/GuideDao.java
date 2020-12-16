package dao;

import java.util.List;

import bean.Guide;

public interface GuideDao {
	List<Guide> findAllGrammarGuide(int pageId, int count);
	
	List<Guide> findAllVocabularyGuide();
	
	Guide getById(int guideId);
	
	void save(Guide guides);
	
	int countGrammar();
	
	int countVocabulary();
}
