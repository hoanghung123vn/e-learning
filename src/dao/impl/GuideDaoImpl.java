package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Guide;
import dao.GuideDao;
import database.DBConnection;
import enumeration.GuideType;

public class GuideDaoImpl  implements GuideDao{
	@Override
	public void save(Guide guide) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public List<Guide> findAll(int pageID, int count, GuideType guideType) {
		Connection connection = DBConnection.getInstance();
		return null;
	}


	@Override
	public Guide getById(int guideId) {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public int count(GuideType guideType) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}


	@Override
	public boolean updateContent(String content,int guideId) {
		Connection connection = DBConnection.getInstance();
		return false;
	}

	@Override
	public Guide insertGuide(Guide guide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guide> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
