package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Guide;
import dao.GuideDao;
import database.DBConnection;

public class GuideDaoImpl  implements GuideDao{
	@Override
	public void save(Guide guide) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public List<Guide> findAllGrammarGuide(int pageID, int count) {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public List<Guide> findAllVocabularyGuide() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public Guide getById(int guideId) {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public int countGrammar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countVocabulary() {
		// TODO Auto-generated method stub
		return 0;
	}

}
