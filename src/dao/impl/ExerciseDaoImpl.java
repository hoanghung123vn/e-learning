package dao.impl;

import bean.Exercise;
import dao.ExerciseDao;
import database.DBConnection;
import enumeration.QuestionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDaoImpl implements ExerciseDao {

	@Override
	public boolean save(Exercise exercise) {
		Connection connection = DBConnection.getInstance();
		String sql = "insert into exercises (title, image_path, checked_question, type) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, exercise.getTitle());
			ps.setString(2, exercise.getImagePath());
			ps.setInt(3, exercise.getCheckedQuestion());
			ps.setString(4, exercise.getType().toString());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int count(QuestionType questionType) {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from exercises where type = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, questionType.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Exercise> findAll(int pageId, int count, QuestionType questionType) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from exercises where type = ? limit ?, ?";
		List<Exercise> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, pageId - 1);
			ps.setInt(2, count);
			ps.setString(3, questionType.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Exercise exercise = new Exercise();
				exercise.setId(rs.getInt("id"));
				exercise.setImagePath(rs.getString("image_path"));
				exercise.setTitle(rs.getString("title"));
				exercise.setType(questionType);
				exercise.setCheckedQuestion(rs.getInt("checked_question"));
				result.add(exercise);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Exercise> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkedExercise(int exerciseId) {
		Connection connection = DBConnection.getInstance();
		String sql = "update exercises set checked_question = 1 where exercise_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, exerciseId);
			ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
