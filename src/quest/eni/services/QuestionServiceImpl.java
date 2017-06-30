package quest.eni.services;

import java.util.List;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Question;
import quest.eni.entities.Theme;

public class QuestionServiceImpl implements QuestionService{

	private static QuestionService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static QuestionService getInstance() {
		if (instance == null) {
			instance = new QuestionServiceImpl();
		}
		return instance;
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = this.daoFactory.getQuestionDAO().getAllQuestion();
//		for(Question q : questions){
//			int id = q.getTheme().getIdTheme();
//			q.setTheme(themeService.getThemeById(id));
//		}
		return questions;
	}

	@Override
	public int saveQuestion(Question question) {
		int id = 0;
		if(question.getIdQuestion() == 0)
			id = this.daoFactory.getQuestionDAO().saveQuestion(question);
		else
			this.daoFactory.getQuestionDAO().updateQuestion(question);
		
		return id;
	}

	@Override
	public Question getQuestionReponseById(int idQuestion) {
		return this.daoFactory.getQuestionDAO().getQuestionReponseById(idQuestion);
	}

	@Override
	public int deleteQuestion(int idQuestion) {
		this.daoFactory.getReponseDAO().deleteReponse(idQuestion);
		return this.daoFactory.getQuestionDAO().deleteQuestion(idQuestion);
		
	}

	@Override
	public List<Question> getAllByTheme(int idTheme) {
		return this.daoFactory.getQuestionDAO().getAllByTheme(idTheme);
	}
	
}
