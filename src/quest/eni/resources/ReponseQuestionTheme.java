package quest.eni.resources;

import java.util.List;

import quest.eni.entities.Question;
import quest.eni.entities.Theme;

public class ReponseQuestionTheme {

	private List<Question> questions;
	private Theme theme;
	
	public ReponseQuestionTheme(List<Question> questions, Theme theme) {
		super();
		this.setQuestions(questions);
		this.setTheme(theme);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	
	
}
