package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.ListenQuestion;
import dao.ListenQuestionDao;
import database.DBConnection;

public class ListenQuestionDaoImpl implements ListenQuestionDao {

	public List<ListenQuestion> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(ListenQuestion listenQuestion) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public List<ListenQuestion> findAllByExerciseId(int exerciseId, int pageId, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByExerciseId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ListenQuestion> getByExerciseIdAndNo(int exerciseId, int no) {
		// TODO Auto-generated method stub
		return null;
	}

}
