package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	List<User> findAll();
	
	boolean save(User user);
	
	User getByUserName(String userName);
}
