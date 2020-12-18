package dao.impl;

import bean.SlideBanner;
import dao.SlideBannerDao;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SlideBannerDaoImpl implements SlideBannerDao {

	@Override
	public List<SlideBanner> findAll() {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from slide_banners";
		List<SlideBanner> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SlideBanner slideBanner = new SlideBanner();
				slideBanner.setId(rs.getInt("id"));
				slideBanner.setContent(rs.getString("content"));
				slideBanner.setImagePath(rs.getString("image_path"));
				slideBanner.setTitle(rs.getString("title"));
				result.add(slideBanner);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public void save(SlideBanner slideBanner) {
		Connection connection = DBConnection.getInstance();
		String sql = "insert into slide_banners (title, content, image_path) values(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, slideBanner.getTitle());
			ps.setString(2, slideBanner.getContent());
			ps.setString(3, slideBanner.getImagePath());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
