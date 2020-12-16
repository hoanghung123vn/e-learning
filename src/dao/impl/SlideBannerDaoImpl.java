package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.SlideBanner;
import dao.SlideBannerDao;
import database.DBConnection;

public class SlideBannerDaoImpl implements SlideBannerDao {

	@Override
	public List<SlideBanner> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(SlideBanner slideBanner) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
