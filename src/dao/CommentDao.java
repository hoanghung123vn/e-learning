package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao {
	List<Comment> findAll();
	
	List<Comment> findByGuideId(int guideId);
	
	boolean save(Comment comment);
	
	int countById(int id);
	
	void deleteByGuideId(int guideId);
}
