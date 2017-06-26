package quest.eni.services;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Personne;

public class PersonneServiceImpl implements PersonneService{

	private static PersonneService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static PersonneService getInstance() {
		if (instance == null) {
			instance = new PersonneServiceImpl();
		}
		return instance;
	}

	@Override
	public Personne getStagOrForm(String login) {
		return this.daoFactory.getPersonneDAO().getStagOrForm(login);
	}

	@Override
	public boolean verifyLogin(String login, String pw) {
		return this.daoFactory.getPersonneDAO().isValid(login, pw);
	}

	@Override
	public int getNbPersonne() {
		return this.daoFactory.getPersonneDAO().getNbPersonne();
	}
	
}
