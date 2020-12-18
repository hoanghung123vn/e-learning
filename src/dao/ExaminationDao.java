package dao;

import java.util.List;

import bean.Examination;

public interface ExaminationDao {
	List<Examination> findAll(int pageId, int size);
	
	boolean save(Examination examination);
	
	int count();
}
