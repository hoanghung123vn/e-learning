package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Exercise;
import dao.ExerciseDao;
import database.DBConnection;
import enumeration.QuestionType;

public class ExerciseDaoImpl implements ExerciseDao {

	@Override
	public void save(Exercise exercise) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int count(QuestionType questionType) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

	@Override
	public List<Exercise> findAll(int pageId, int count, QuestionType questionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exercise> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
