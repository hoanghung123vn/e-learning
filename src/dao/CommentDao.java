package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao {
	List<Comment> findAll();
	
	void save(Comment comment);
	
	int countById(int id);
}
