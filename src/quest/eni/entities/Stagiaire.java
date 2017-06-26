package quest.eni.entities;

public class Stagiaire extends Personne{

	private int idStagiaire;

	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stagiaire(int idStagiaire) {
		this();
		setIdStagiaire(idStagiaire);
		// TODO Auto-generated constructor stub
	}

	public int getIdStagiaire() {
		return idStagiaire;
	}

	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
	}
	
}
