package quest.eni.entities;

public class Formateur extends Personne{
	
	private int idFormateur;

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Formateur(int idFormateur) {
		this();
		setIdFormateur(idFormateur);
	}
	
	public int getIdFormateur() {
		return idFormateur;
	}
	
	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}	
}
