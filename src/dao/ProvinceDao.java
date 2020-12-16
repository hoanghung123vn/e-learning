package dao;

import java.util.List;

import bean.Province;

public interface ProvinceDao {
	List<Province> findAll();
	
	void save(Province province);
	
	int countById(int id);
}
