package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	List<User> findAll();
	
	void save(User user);
	
	int countById(int id);
}
