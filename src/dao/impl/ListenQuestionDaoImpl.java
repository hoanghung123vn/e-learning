package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.ListenQuestion;
import dao.ListenQuestionDao;
import database.DBConnection;

public class ListenQuestionDaoImpl implements ListenQuestionDao {

	@Override
	public List<ListenQuestion> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(ListenQuestion listenQuestion) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
