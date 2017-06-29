package quest.eni.entities;

import quest.eni.services.SectionService;
import quest.eni.services.SectionServiceImpl;

public class Section {
	
	private int idSection;
	private Theme theme;
	private Epreuve epreuve;
	private int nbrQuestion;
	private static SectionService sectionService = SectionServiceImpl.getInstance();
	
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Section(int idSection) {
		this();
		Section s = sectionService.getById(idSection);
		this.setIdSection(idSection);
		this.setNbrQuestion(s.getNbrQuestion());
		this.setTheme(s.getTheme());
	}
	
	public int getIdSection() {
		return idSection;
	}
	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public int getNbrQuestion() {
		return nbrQuestion;
	}
	public void setNbrQuestion(int nbrQuestion) {
		this.nbrQuestion = nbrQuestion;
	}
	public Epreuve getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}
	

}
