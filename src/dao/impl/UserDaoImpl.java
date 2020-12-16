package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.User;
import dao.UserDao;
import database.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(User user) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
