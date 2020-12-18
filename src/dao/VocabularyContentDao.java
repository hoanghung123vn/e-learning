package dao;

import java.util.List;

import bean.VocabularyContent;

public interface VocabularyContentDao {
	List<VocabularyContent> findAllByGuideId(int guideId);
}
