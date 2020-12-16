package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.VocabularyContent;
import dao.VocabularyContentDao;
import database.DBConnection;

public class VocabularyContentDaoImpl implements VocabularyContentDao {

	@Override
	public List<VocabularyContent> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(VocabularyContent vocabularyContent) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
