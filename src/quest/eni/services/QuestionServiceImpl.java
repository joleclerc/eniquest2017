package quest.eni.services;

import java.util.List;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Question;
import quest.eni.entities.Theme;

public class QuestionServiceImpl implements QuestionService{

	private static QuestionService instance;
	private static ThemeService themeService = ThemeServiceImpl.getInstance();
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
		for(Question q : questions){
			int id = q.getTheme().getIdTheme();
			q.setTheme(themeService.getThemeById(id));
		}
		return questions;
	}

	@Override
	public void saveQuestion(Question question) {
		if(question.getIdQuestion() == 0)
			this.daoFactory.getQuestionDAO().saveQuestion(question);
		else
			this.daoFactory.getQuestionDAO().updateQuestion(question);
	}

	@Override
	public Question getQuestionById(int idQuestion) {
		return this.daoFactory.getQuestionDAO().getQuestionById(idQuestion);
	}

	@Override
	public int deleteQuestion(int idQuestion) {
		return this.daoFactory.getQuestionDAO().deleteQuestion(idQuestion);
		
	}
	
}
