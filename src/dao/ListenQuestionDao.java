package dao;

import java.util.List;

import bean.ListenQuestion;

public interface ListenQuestionDao {
	List<ListenQuestion> findAllByExerciseId(int exerciseId, int pageId, int size);
	
	void save(ListenQuestion listenQuestion);
	
	int countByExerciseId(int id);
	
	List<ListenQuestion> getByExerciseIdAndNo(int exerciseId, int no);
}
