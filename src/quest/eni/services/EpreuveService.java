package quest.eni.services;

import java.util.List;

import quest.eni.entities.Epreuve;

public interface EpreuveService {

	public int saveEpreuve(Epreuve epreuve);
	
	public List<Epreuve> getAllEpreuve();
	
	public Epreuve getEpreuveDetailsById(int idEpreuve);
}
