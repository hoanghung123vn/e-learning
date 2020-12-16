package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Province;
import dao.ProvinceDao;
import bean.Province;
import database.DBConnection;

public class ProvinceDaoImpl implements ProvinceDao {

	@Override
	public List<Province> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(Province province) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}
}
