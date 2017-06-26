package quest.eni.services;

import quest.eni.entities.Personne;

public interface PersonneService {

	public Personne getStagOrForm(String login);
	
	public boolean verifyLogin(String login, String pw);
	
	public int getNbPersonne();
	
}
