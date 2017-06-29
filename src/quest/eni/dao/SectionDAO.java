package quest.eni.dao;

import quest.eni.entities.Section;

public interface SectionDAO {

	public void saveSection(Section section);
	
	public Section getById(int idSection);
}
