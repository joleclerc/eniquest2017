package quest.eni.dao;

import java.util.List;

import quest.eni.entities.Question;
import quest.eni.entities.Reponse;

public interface ReponseDAO {
	
	public Reponse getReponseByIdWithoutQuestion(int idReponse);
	
	public void insertReponse(Reponse reponse);
	
	public void updateReponse(Reponse reponse);
	
	public List<Reponse> getReponseForQuestion(Question question);
	
}
