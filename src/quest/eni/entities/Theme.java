package quest.eni.entities;

import quest.eni.services.ThemeService;
import quest.eni.services.ThemeServiceImpl;

public class Theme {

	private int idTheme;
	private String libelleTheme;
	private String description;
	private int nbrQuestion;
	private static ThemeService themeService = ThemeServiceImpl.getInstance();
	
	public Theme() {
		super();
	}
	
	public Theme(int idTheme) {
		this();
		Theme t = themeService.getThemeById(idTheme);
		this.setIdTheme(idTheme);
		this.setDescription(t.getDescription());
		this.setLibelleTheme(t.getLibelleTheme());
		this.setNbrQuestion(t.getNbrQuestion());
	}
	
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public String getLibelleTheme() {
		return libelleTheme;
	}
	public void setLibelleTheme(String libelleTheme) {
		this.libelleTheme = libelleTheme;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbrQuestion() {
		return nbrQuestion;
	}
	public void setNbrQuestion(int nbrQuestion) {
		this.nbrQuestion = nbrQuestion;
	}
	
	@Override
	public String toString(){
		return "THEME : " + this.getIdTheme() + " | " + this.getLibelleTheme() + " | " + this.getDescription();
	}
	
}
