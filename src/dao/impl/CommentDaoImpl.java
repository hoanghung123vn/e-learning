package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Comment;
import dao.CommentDao;
import database.DBConnection;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(Comment comment) {
		Connection connection = DBConnection.getInstance();
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

	@Override
	public List<Comment> findByGuideId(int guideId) {
		Connection connection = DBConnection.getInstance();
		return null;
	}

}
