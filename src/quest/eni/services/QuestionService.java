package quest.eni.services;

import java.util.List;

import quest.eni.entities.Question;

public interface QuestionService {

	public List<Question> getAllQuestion();
	
	public int saveQuestion(Question question);
	
	public Question getQuestionReponseById(int idQuestion);
	
	public int deleteQuestion(int idQuestion);
	
	public List<Question> getAllByTheme(int idTheme);
	
}
