package quest.eni.services;

import quest.eni.dao.DAOFactory;
import quest.eni.entities.Epreuve;
import quest.eni.entities.Section;

public class SectionServiceImpl implements SectionService{

	private static SectionService instance;
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public static SectionService getInstance() {
		if (instance == null) {
			instance = new SectionServiceImpl();
		}
		return instance;
	}

	@Override
	public int saveSection(Section section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Section getById(int idSection) {
		return this.daoFactory.getSectionDAO().getById(idSection);
	}

}
