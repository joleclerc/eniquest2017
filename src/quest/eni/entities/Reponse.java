package quest.eni.entities;

import quest.eni.services.ReponseService;
import quest.eni.services.ReponseServiceImpl;

public class Reponse {

	private int idReponse;
	private String libelleReponse;
	private String lienImage;
	private int position;
	private int isValid;
	private Question question;
	private static ReponseService reponseService = ReponseServiceImpl.getInstance();
	
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reponse(int idReponse) {
		this();
		Reponse r = reponseService.getReponseByIdWithoutQuestion(idReponse);
		this.setIdReponse(idReponse);
		this.setLibelleReponse(r.getLibelleReponse());
		this.setLienImage(r.getLienImage());
		this.setIsValid(r.getIsValid());
		this.setPosition(r.getPosition());
	}
	
	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public String getLibelleReponse() {
		return libelleReponse;
	}

	public void setLibelleReponse(String libelleReponse) {
		this.libelleReponse = libelleReponse;
	}

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "ID : " + this.idReponse + " | " + this.libelleReponse + " | isValid : " + this.isValid;
	}
	
}
