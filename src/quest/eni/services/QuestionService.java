package quest.eni.services;

import java.util.List;

import quest.eni.entities.Question;

public interface QuestionService {

	public List<Question> getAllQuestion();
	
	public void saveQuestion(Question Question);
	
	public Question getQuestionById(int idQuestion);
	
	public int deleteQuestion(int idQuestion);
	
}
