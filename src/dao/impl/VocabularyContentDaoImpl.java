package dao.impl;

import bean.VocabularyContent;
import dao.VocabularyContentDao;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VocabularyContentDaoImpl implements VocabularyContentDao {

	@Override
	public List<VocabularyContent> findAllByGuideId(int guideId) {
		Connection connection = DBConnection.getInstance();
		String sql = "select * from voca_contents where voca_guide_id = ?";
		List<VocabularyContent> result = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, guideId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VocabularyContent vocabularyContent = new VocabularyContent();
				vocabularyContent.setId(rs.getInt("id"));
				vocabularyContent.setNum(rs.getInt("num"));
				vocabularyContent.setTitle(rs.getString("title"));
				vocabularyContent.setTranscribe(rs.getString("transcribe"));
				vocabularyContent.setImagePath(rs.getString("image_path"));
				vocabularyContent.setAudiomp3Path(rs.getString("audiomp3_path"));
				vocabularyContent.setAudioggPath(rs.getString("audiogg_path"));
				vocabularyContent.setMean(rs.getString("mean"));
				vocabularyContent.setGuideId(rs.getInt("voca_guide_id"));
				result.add(vocabularyContent);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return result;
	}

}
