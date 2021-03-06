package dao;

import java.util.List;

import bean.Exercise;
import enumeration.QuestionType;

public interface ExerciseDao {
    List<Exercise> findAll();
    
    List<Exercise> findAll(int pageId, int count, QuestionType questionType);
	
	boolean save(Exercise exercise);
	
	int count(QuestionType questionType);
	
	void checkedExercise(int exerciseId);
}
