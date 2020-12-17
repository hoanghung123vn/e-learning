package dao;

import java.util.List;

import bean.ExaminationQuestion;

public interface ExaminationQuestionDao {
	List<ExaminationQuestion> findAllByExamId(int examId);
	
	int countByExamId(int examId);
}
