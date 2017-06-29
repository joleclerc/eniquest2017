package quest.eni.services;

import java.util.List;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Theme;

public class ThemeServiceImpl implements ThemeService{

	private static ThemeService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static ThemeService getInstance() {
		if (instance == null) {
			instance = new ThemeServiceImpl();
		}
		return instance;
	}

	@Override
	public List<Theme> getAllTheme() {
		List<Theme> themes = this.daoFactory.getThemeDAO().getAllTheme();
		for(Theme t : themes){
			int nbQuestion = this.getNbQuestionByTheme(t);
			t.setNbrQuestion(nbQuestion);
		}
		
		return themes;
	}

	@Override
	public void saveTheme(Theme theme) {
		if(theme.getIdTheme() == 0)
			this.daoFactory.getThemeDAO().saveTheme(theme);
		else
			this.daoFactory.getThemeDAO().updateTheme(theme);
	}

	@Override
	public Theme getThemeById(int idTheme) {
		return this.daoFactory.getThemeDAO().getThemeById(idTheme);
	}

	@Override
	public int deleteTheme(int idTheme) {
		return this.daoFactory.getThemeDAO().deleteTheme(idTheme);
		
	}

	@Override
	public int getNbQuestionByTheme(Theme theme) {
		return this.daoFactory.getThemeDAO().getNbQuestionByTheme(theme);
	}
	
}
