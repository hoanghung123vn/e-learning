package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ListenQuestion;
import bean.ReadQuestion;
import dao.ReadQuestionDao;
import database.DBConnection;

public class ReadQuestionDaoImpl implements ReadQuestionDao {

	@Override
	public void save(ReadQuestion readQuestion) {
		Connection connection = DBConnection.getInstance();
	}

	@Override
	public int countByExerciseId(int exerciseId) {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from read_questions where read_exercise_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ReadQuestion> findAllByExerciseId(int exerciseId, int pageId, int size) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from read_questions where read_exercise_id = ? limit ?, ?";
		List<ReadQuestion> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ps.setInt(2, pageId - 1);
			ps.setInt(3, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReadQuestion readQuestion = new ReadQuestion();
				readQuestion.setId(rs.getInt("id"));
				readQuestion.setNo(rs.getInt("no"));
				readQuestion.setQuestion(rs.getString("question"));
				readQuestion.setOption1(rs.getString("option1"));
				readQuestion.setOption2(rs.getString("option2"));
				readQuestion.setOption3(rs.getString("option3"));
				readQuestion.setOption4(rs.getString("option4"));
				readQuestion.setCorrect(rs.getString("correct"));
				readQuestion.setExerciseId(rs.getInt("read_exercise_id"));
				result.add(readQuestion);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ReadQuestion> getByExerciseIdAndNo(int exerciseId, int no) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from read_questions where read_exercise_id = ? and no = ?";
		List<ReadQuestion> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ps.setInt(2, no);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReadQuestion readQuestion = new ReadQuestion();
				readQuestion.setId(rs.getInt("id"));
				readQuestion.setNo(rs.getInt("no"));
				readQuestion.setQuestion(rs.getString("question"));
				readQuestion.setOption1(rs.getString("option1"));
				readQuestion.setOption2(rs.getString("option2"));
				readQuestion.setOption3(rs.getString("option3"));
				readQuestion.setOption4(rs.getString("option4"));
				readQuestion.setCorrect(rs.getString("correct"));
				readQuestion.setExerciseId(rs.getInt("read_exercise_id"));
				result.add(readQuestion);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

}
