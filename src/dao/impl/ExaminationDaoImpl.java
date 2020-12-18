package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Examination;
import dao.ExaminationDao;
import database.DBConnection;

public class ExaminationDaoImpl implements ExaminationDao {

	@Override
	public List<Examination> findAll(int pageId, int size) {
		Connection connection = DBConnection.getInstance();
		List<Examination> result = new ArrayList<>();
		String sql = "select * from examinations limit ?, ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, pageId - 1);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Examination examination = new Examination();
				examination.setId(rs.getInt("id"));
				examination.setCheckedQuestion(rs.getInt("checked_question"));
				examination.setTitle(rs.getString("title"));
				examination.setImagePath(rs.getString("image_path"));
				result.add(examination);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean save(Examination examination) {
		Connection connection = DBConnection.getInstance();
		String sql = "insert into examinations (title, image_path, checked_question) values(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, examination.getTitle());
			ps.setString(2, examination.getImagePath());
			ps.setInt(3, examination.getCheckedQuestion());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int count() {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from examinations";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}

}
