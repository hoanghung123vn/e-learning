package dao;

import java.util.List;

import bean.SlideBanner;

public interface SlideBannerDao {
	List<SlideBanner> findAll();
	
	void save(SlideBanner slideBanner);
	
	int countById(int id);
}
