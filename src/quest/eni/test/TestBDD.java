package quest.eni.test;

import quest.eni.services.PersonneService;
import quest.eni.services.PersonneServiceImpl;

public class TestBDD {

	public static void main(String[] args) {
		PersonneService pService = PersonneServiceImpl.getInstance();

		System.out.println("Il y a " + pService.getNbPersonne() + " dans la table Personne !!!!");
		
	}

}
