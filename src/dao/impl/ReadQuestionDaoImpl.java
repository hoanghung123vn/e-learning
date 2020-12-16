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
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
