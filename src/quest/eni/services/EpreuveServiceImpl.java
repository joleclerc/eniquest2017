package quest.eni.services;

import java.util.List;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Epreuve;

public class EpreuveServiceImpl implements EpreuveService{

	private static EpreuveService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static EpreuveService getInstance() {
		if (instance == null) {
			instance = new EpreuveServiceImpl();
		}
		return instance;
	}

	@Override
	public int saveEpreuve(Epreuve epreuve) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Epreuve> getAllEpreuve() {
		return this.daoFactory.getEpreuveDAO().getAllEpreuve();
	}

	@Override
	public Epreuve getEpreuveDetailsById(int idEpreuve) {
		return this.daoFactory.getEpreuveDAO().getEpreuveDetailsById(idEpreuve);
	}	
}
