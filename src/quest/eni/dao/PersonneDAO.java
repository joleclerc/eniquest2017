package quest.eni.dao;

import quest.eni.entities.Personne;

public interface PersonneDAO {

	public Personne getStagOrForm(String login);
	
	public boolean isValid(String login, String pw);
	
	public Personne getPersonne(String login);
	
	public int getNbPersonne();
	
}
