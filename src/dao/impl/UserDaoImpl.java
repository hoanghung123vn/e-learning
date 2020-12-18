package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType;

import bean.User;
import dao.UserDao;
import database.DBConnection;
import enumeration.Role;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public boolean save(User user) {
		Connection connection = DBConnection.getInstance();
		String query = "select count(*) from users where user_name = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			rs.next();
			count = rs.getInt(1);
			
			if (count > 0)
				return false;
			
			String sql = "insert into users (name, user_name, password, role) values(?, ?, ?, ?)";
			String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserName());
			ps.setString(3, password);
			ps.setString(4, Role.MEMBER.toString());
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
	public User getByUserName(String userName) {
		Connection connection = DBConnection.getInstance();
		String query = "select * from users where user_name = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			User user = new User();
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setRole(Role.valueOf(rs.getString("role")));
			}
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
