package dao.impl;

import java.sql.Connection;
import java.util.List;

import bean.Examination;
import dao.ExaminationDao;
import database.DBConnection;

public class ExaminationDaoImpl implements ExaminationDao {

	@Override
	public List<Examination> findAll() {
		Connection connection = DBConnection.getInstance();
		return null;
	}

	@Override
	public void save(Examination examination) {
		Connection connection = DBConnection.getInstance();
		
	}

	@Override
	public int countById(int id) {
		Connection connection = DBConnection.getInstance();
		return 0;
	}

}
