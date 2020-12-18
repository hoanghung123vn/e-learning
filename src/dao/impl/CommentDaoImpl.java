package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public boolean save(Comment comment) {
        Connection connection = DBConnection.getInstance();
        String sql = "insert into comments (content, guide_id, user_id) values(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, comment.getContent());
            ps.setInt(2, comment.getGuideId());
            ps.setInt(3, comment.getUserId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

    @Override
    public int countById(int id) {
        Connection connection = DBConnection.getInstance();
        return 0;
    }

    @Override
    public List<Comment> findByGuideId(int guideId) {
        Connection connection = DBConnection.getInstance();
        List<Comment> result = new ArrayList<>();
        String sql = "select * from comments where guide_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, guideId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setContent(rs.getString("content"));
				comment.setGuideId(rs.getInt("guide_id"));
				comment.setUserId(rs.getInt("user_id"));
				result.add(comment);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
    }

    @Override
    public void deleteByGuideId(int guideId) {
		Connection connection = DBConnection.getInstance();
		String sql = "delete from comments where guide_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, guideId);
			ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
