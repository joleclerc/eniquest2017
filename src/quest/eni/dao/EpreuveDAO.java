package quest.eni.dao;

import java.util.List;

import quest.eni.entities.Epreuve;

public interface EpreuveDAO {

	public void saveEpreuve(Epreuve epreuve);
	
	public List<Epreuve> getAllEpreuve();
	
	public Epreuve getEpreuveDetailsById(int idEpreuve);
	
}
