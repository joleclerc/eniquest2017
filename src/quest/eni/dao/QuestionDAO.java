package quest.eni.dao;

import java.util.List;

import quest.eni.entities.Question;

public interface QuestionDAO {

	public List<Question> getAllQuestion();
	
	public int saveQuestion(Question question);
	
	public Question getQuestionReponseById(int idQuestion);
	
	public int deleteQuestion(int idQuestion);
	
	public void updateQuestion(Question Question);
	
	public List<Question> getAllByTheme(int idTheme);
	
}
