package quest.eni.resources;

import quest.eni.entities.Personne;

public class ReponseLogin {

	private Personne pers;
	private boolean isValid;
	private boolean isFormateur;
	

	public ReponseLogin(Personne pers, boolean isValid, boolean isFormateur){
		super();
		setPers(pers);
		setValid(isValid);
		setFormateur(isFormateur);
		
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean isFormateur() {
		return isFormateur;
	}
	
	public void setFormateur(boolean isFormateur) {
		this.isFormateur = isFormateur;
	}
	
	public ReponseLogin(){
		super();
	}

	public Personne getPers() {
		return pers;
	}
	public void setPers(Personne pers) {
		this.pers = pers;
	}
	
	
	
}
