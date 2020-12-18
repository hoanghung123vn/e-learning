package dao;

import java.util.List;

import bean.ReadQuestion;

public interface ReadQuestionDao {
	List<ReadQuestion> findAllByExerciseId(int exerciseId, int pageId, int size);
	
	void save(ReadQuestion readQuestion);
	
	int countByExerciseId(int exerciseId);
	
	List<ReadQuestion> getByExerciseIdAndNo(int exerciseId, int no);
}
