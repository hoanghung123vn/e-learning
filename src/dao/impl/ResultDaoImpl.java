package dao.impl;

import bean.Result;
import dao.ResultDao;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ResultDaoImpl implements ResultDao {

	@Override
	public void save(Result result) {
		Connection connection = DBConnection.getInstance();
		String sql = "insert into results (sum_correct_read, sum_correct_listen, sum_incorrect, user_id, exam_id" +
				", timestamp) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, result.getSumReadCorrect());
			ps.setInt(2, result.getSumListenCorrect());
			ps.setInt(3, result.getSumIncorrect());
			ps.setInt(4, result.getUserId());
			ps.setInt(5, result.getExamId());
			ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
