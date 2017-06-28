package quest.eni.dao;

import quest.eni.entities.Reponse;

public interface ReponseDAO {
	
	public Reponse getReponseByIdWithoutQuestion(int idReponse);
	
	public void insertReponse(Reponse reponse);
	
	public void updateReponse(Reponse reponse);
	
}
