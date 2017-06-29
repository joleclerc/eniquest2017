package quest.eni.entities;

import java.util.Date;
import java.util.List;

public class Epreuve {

	private int idEpreuve;
	private int nbrQuestion;
	private Date dateCreation;
	private String libelleEpreuve;
	private int tempsEpreuve;
	private String typeEpreuve;
	private List<Stagiaire> stagiaire;
	private List<Section> sections;
	
	public Epreuve() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdEpreuve() {
		return idEpreuve;
	}
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}
	public int getNbrQuestion() {
		return nbrQuestion;
	}
	public void setNbrQuestion(int nbrQuestion) {
		this.nbrQuestion = nbrQuestion;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getLibelleEpreuve() {
		return libelleEpreuve;
	}
	public void setLibelleEpreuve(String libelleEpreuve) {
		this.libelleEpreuve = libelleEpreuve;
	}
	public int getTempsEpreuve() {
		return tempsEpreuve;
	}
	public void setTempsEpreuve(int tempsEpreuve) {
		this.tempsEpreuve = tempsEpreuve;
	}
	public String getTypeEpreuve() {
		return typeEpreuve;
	}
	public void setTypeEpreuve(String typeEpreuve) {
		this.typeEpreuve = typeEpreuve;
	}
	public List<Stagiaire> getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(List<Stagiaire> stagiaire) {
		this.stagiaire = stagiaire;
	}

	/**
	 * @return the sections
	 */
	public List<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
	
}
