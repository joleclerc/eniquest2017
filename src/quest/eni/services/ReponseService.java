package quest.eni.services;

import java.util.List;

import quest.eni.entities.Question;
import quest.eni.entities.Reponse;

public interface ReponseService {
	
	public Reponse getReponseByIdWithoutQuestion(int idReponse);
	
	public void insertReponse(Reponse reponse);
	
	public void updateReponse(Reponse reponse);
	
	public List<Reponse> getReponseForQuestion(Question question);

}
