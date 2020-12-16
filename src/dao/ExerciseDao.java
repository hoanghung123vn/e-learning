package dao;

import java.util.List;

import bean.Exercise;

public interface ExerciseDao {
    List<Exercise> findAll();
	
	void save(Exercise exercise);
	
	int countById(int id);
}
