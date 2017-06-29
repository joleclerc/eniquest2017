package quest.eni.services;

import java.util.List;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Question;
import quest.eni.entities.Reponse;

public class ReponseServiceImpl implements ReponseService{

	private static ReponseService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static ReponseService getInstance() {
		if (instance == null) {
			instance = new ReponseServiceImpl();
		}
		return instance;
	}

	@Override
	public Reponse getReponseByIdWithoutQuestion(int idReponse) {
		return this.daoFactory.getReponseDAO().getReponseByIdWithoutQuestion(idReponse);
	}

	@Override
	public void insertReponse(Reponse reponse) {
		this.daoFactory.getReponseDAO().insertReponse(reponse);
	}

	@Override
	public void updateReponse(Reponse reponse) {
		this.daoFactory.getReponseDAO().updateReponse(reponse);
	}

	@Override
	public List<Reponse> getReponseForQuestion(Question question) {
		return this.daoFactory.getReponseDAO().getReponseForQuestion(question);
	}

		
}
