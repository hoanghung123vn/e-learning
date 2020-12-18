package dao.impl;

import bean.Guide;
import dao.GuideDao;
import database.DBConnection;
import enumeration.GuideType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuideDaoImpl  implements GuideDao{
	@Override
	public List<Guide> findAll(int pageId, int count, GuideType guideType) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from guides where type = ? limit ?, ?";
		List<Guide> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, pageId - 1);
			ps.setInt(2, count);
			ps.setString(3, guideType.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Guide guide = new Guide();
				guide.setId(rs.getInt("id"));
				guide.setImagePath(rs.getString("image_path"));
				guide.setTitle(rs.getString("title"));
				guide.setGuideType(guideType);
				result.add(guide);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}


	@Override
	public Guide getById(int guideId) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from guides where guide_id = ?";
		Guide result = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, guideId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.setId(rs.getInt("id"));
				result.setContent(rs.getString("content"));
				result.setImagePath(rs.getString("image_path"));
				result.setGuideType(GuideType.valueOf(rs.getString("type")));
				result.setTitle(rs.getString("title"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public int count(GuideType guideType) {
		Connection connection = DBConnection.getInstance();
		String sql = "select count(*) from guides where type = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, guideType.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return 0;
	}


	@Override
	public boolean updateContent(String content,int guideId) {
		Connection connection = DBConnection.getInstance();
		String sql = "update guides set content = ? where guide_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(1, guideId);
			return ps.executeUpdate() == 1;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertGuide(Guide guide) {
		Connection connection = DBConnection.getInstance();
		String sql = "insert into guides (title, image_path, content, type) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, guide.getTitle());
			ps.setString(2, guide.getImagePath());
			ps.setString(3, guide.getContent());
			ps.setString(4, guide.getGuideType().toString());
			return ps.executeUpdate() == 1;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Guide> findByTitle(String title) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from guides where title = ?";
		List<Guide> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Guide guide = new Guide();
				guide.setId(rs.getInt("id"));
				guide.setTitle(rs.getString("title"));
				guide.setImagePath(rs.getString("image_path"));
				guide.setContent(rs.getString("content"));
				guide.setGuideType(GuideType.valueOf(rs.getString("type")));
				result.add(guide);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

	@Override
	public void delete(int id) {
		Connection connection = DBConnection.getInstance();
		String sql = "delete from guides where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
