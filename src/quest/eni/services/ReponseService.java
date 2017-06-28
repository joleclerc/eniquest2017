package quest.eni.services;

import quest.eni.entities.Reponse;

public interface ReponseService {
	
	public Reponse getReponseByIdWithoutQuestion(int idReponse);
	
	public void insertReponse(Reponse reponse);
	
	public void updateReponse(Reponse reponse);

}
