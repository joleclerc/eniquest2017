package quest.eni.services;

import quest.eni.entities.Section;

public interface SectionService {

	public int saveSection(Section section);
	
	public Section getById(int idSection);
	
}
