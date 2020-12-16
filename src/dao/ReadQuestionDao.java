package dao;

import java.util.List;

import bean.ReadQuestion;

public interface ReadQuestionDao {
	List<ReadQuestion> findAll();
	
	void save(ReadQuestion readQuestion);
	
	int countById(int id);
}
