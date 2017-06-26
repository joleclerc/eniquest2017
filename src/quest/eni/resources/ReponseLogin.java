package quest.eni.resources;

import quest.eni.entities.Personne;

public class ReponseLogin {

	private String rep;
	private Personne pers;
	
	public ReponseLogin(String rep, Personne pers){
		super();
		setRep(rep);
		setPers(pers);
	}
	
	public ReponseLogin(){
		super();
	}
	
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Personne getPers() {
		return pers;
	}
	public void setPers(Personne pers) {
		this.pers = pers;
	}
	
	
	
}
