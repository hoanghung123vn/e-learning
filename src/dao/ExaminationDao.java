package dao;

import java.util.List;

import bean.Examination;

public interface ExaminationDao {
	List<Examination> findAll();
	
	void save(Examination examination);
	
	int countById(int id);
}
