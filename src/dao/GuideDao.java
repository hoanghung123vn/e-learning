package dao;

import java.util.List;

import bean.Guide;

public interface GuideDao {
	List<Guide> findAll();
	
	void save(Guide guides);
	
	int countById(int id);
}
