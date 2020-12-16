package dao;

import java.util.List;

import bean.ListenQuestion;

public interface ListenQuestionDao {
	List<ListenQuestion> findAll();
	
	void save(ListenQuestion listenQuestion);
	
	int countById(int id);
}
