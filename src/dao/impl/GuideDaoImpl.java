package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Guide;
import dao.GuideDao;
import database.DBConnection;

public class GuideDaoImpl  implements GuideDao{

	@Override
	public List<Guide> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(Guide guide) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
