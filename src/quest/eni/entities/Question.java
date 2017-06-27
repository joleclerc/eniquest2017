package quest.eni.entities;

public class Question {

	private int idQuestion;
	private String intitule;
	private String lienImage;
	private String typeReponse;
	private Theme theme;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	public String getTypeReponse() {
		return typeReponse;
	}

	public void setTypeReponse(String typeReponse) {
		this.typeReponse = typeReponse;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
}
