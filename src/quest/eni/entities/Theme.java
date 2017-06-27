package quest.eni.entities;

public class Theme {

	private int idTheme;
	private String libelleTheme;
	private String description;
	private String nbrQuestion;
	
	public Theme() {
		super();
	}
	
	public Theme(int idTheme) {
		this();
		this.setIdTheme(idTheme);
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
	public String getNbrQuestion() {
		return nbrQuestion;
	}
	public void setNbrQuestion(String nbrQuestion) {
		this.nbrQuestion = nbrQuestion;
	}
	
	@Override
	public String toString(){
		return "THEME : " + this.getIdTheme() + " | " + this.getLibelleTheme() + " | " + this.getDescription();
	}
	
}
