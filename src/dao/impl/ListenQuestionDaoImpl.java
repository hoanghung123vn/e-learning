package dao.impl;

import bean.ListenQuestion;
import dao.ListenQuestionDao;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListenQuestionDaoImpl implements ListenQuestionDao {
	@Override
	public boolean save(ListenQuestion listenQuestion) {
		Connection connection = DBConnection.getInstance();
		return false;
	}

	@Override
	public List<ListenQuestion> findAllByExerciseId(int exerciseId, int pageId, int size) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from listen_questions where listen_exercise_id = ? limit ?, ?";
		List<ListenQuestion> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ps.setInt(2, pageId - 1);
			ps.setInt(3, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListenQuestion listenQuestion = new ListenQuestion();
				listenQuestion.setId(rs.getInt("id"));
				listenQuestion.setNo(rs.getInt("no"));
				listenQuestion.setQuestion(rs.getString("question"));
				listenQuestion.setAudiomp3Path(rs.getString("audiomp3_path"));
				listenQuestion.setAudioggPath(rs.getString("audiogg_path"));
				listenQuestion.setImagePath(rs.getString("image_path"));
				listenQuestion.setOption1(rs.getString("option1"));
				listenQuestion.setOption2(rs.getString("option2"));
				listenQuestion.setOption3(rs.getString("option3"));
				listenQuestion.setOption4(rs.getString("option4"));
				listenQuestion.setCorrect(rs.getString("correct"));
				listenQuestion.setExerciseId(rs.getInt("listen_exercise_id"));
				result.add(listenQuestion);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public int countByExerciseId(int id) {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from listen_questions where listen_exercise_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ListenQuestion> getByExerciseIdAndNo(int exerciseId, int no) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from listen_questions where listen_exercise_id = ? and no = ?";
		List<ListenQuestion> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ps.setInt(2, no);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ListenQuestion listenQuestion = new ListenQuestion();
				listenQuestion.setId(rs.getInt("id"));
				listenQuestion.setNo(rs.getInt("no"));
				listenQuestion.setAudiomp3Path(rs.getString("audiomp3_path"));
				listenQuestion.setAudioggPath(rs.getString("audioog_path"));
				listenQuestion.setImagePath(rs.getString("image_path"));
				listenQuestion.setOption1(rs.getString("option1"));
				listenQuestion.setOption2(rs.getString("option2"));
				listenQuestion.setOption3(rs.getString("option3"));
				listenQuestion.setOption4(rs.getString("option4"));
				listenQuestion.setCorrect(rs.getString("correct"));
				listenQuestion.setExerciseId(rs.getInt("listen_exercise_id"));
				result.add(listenQuestion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
