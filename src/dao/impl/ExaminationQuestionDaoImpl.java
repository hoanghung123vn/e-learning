package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ExaminationQuestion;
import dao.ExaminationQuestionDao;
import database.DBConnection;

public class ExaminationQuestionDaoImpl implements ExaminationQuestionDao {

	@Override
	public List<ExaminationQuestion> findAllByExamId(int examId) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from exam_questions where examId = ?";
		List<ExaminationQuestion> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, examId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExaminationQuestion examinationQuestion = new ExaminationQuestion();
				examinationQuestion.setId(rs.getInt("id"));
				examinationQuestion.setAudiomp3Path(rs.getString("audiomp3_path"));
				examinationQuestion.setAudioggPath(rs.getString("audioog_path"));
				examinationQuestion.setImagePath(rs.getString("image_path"));
				examinationQuestion.setOption1(rs.getString("option1"));
				examinationQuestion.setOption2(rs.getString("option2"));
				examinationQuestion.setOption3(rs.getString("option3"));
				examinationQuestion.setOption4(rs.getString("option4"));
				examinationQuestion.setCorrect(rs.getString("correct"));
				examinationQuestion.setExamId(rs.getInt("exam_id"));
				result.add(examinationQuestion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int countByExamId(int examId) {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from exam_questions where exam_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, examId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

	@Override
	public ExaminationQuestion getQuestionByExamIdAndNo(int examId, int no) {
		Connection connection = DBConnection.getInstance();
		ExaminationQuestion result = null;
		String sql = "select * from exam_questions where exam_id = ? and no = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, examId);
			ps.setInt(2, no);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setExamId(examId);
				result.setNo(no);
				result.setQuestion(rs.getString("question"));
				result.setImagePath(rs.getString("image_path"));
				result.setAudioggPath(rs.getString("audiogg_path"));
				result.setAudiomp3Path(rs.getString("audiomp3_path"));
				result.setOption1(rs.getString("option1"));
				result.setOption2(rs.getString("option2"));
				result.setOption3(rs.getString("option3"));
				result.setOption4(rs.getString("option4"));
				result.setCorrect(rs.getString("correct"));
				result.setExamId(rs.getInt("examId"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

}
