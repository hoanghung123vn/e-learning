package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Exercise;
import dao.ExerciseDao;
import database.DBConnection;

public class ExerciseDaoImpl implements ExerciseDao {

	@Override
	public List<Exercise> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(Exercise exercise) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
