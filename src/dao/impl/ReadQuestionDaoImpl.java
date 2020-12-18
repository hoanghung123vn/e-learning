package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.ReadQuestion;
import dao.ReadQuestionDao;
import database.DBConnection;

public class ReadQuestionDaoImpl implements ReadQuestionDao {

	@Override
	public List<ReadQuestion> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(ReadQuestion readQuestion) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countByExerciseId(int exerciseId) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

	@Override
	public List<ReadQuestion> findAllByExerciseId(int exerciseId, int pageId, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReadQuestion> getByExerciseIdAndNo(int exerciseId, int no) {
		// TODO Auto-generated method stub
		return null;
	}

}
