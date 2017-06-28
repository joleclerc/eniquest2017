package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import quest.eni.entities.Question;
import quest.eni.entities.Reponse;
import quest.eni.entities.Theme;

public class QuestionDAOImpl implements QuestionDAO{

	private static QuestionDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_ALL_QUESTION = "SELECT idQuestion, intitule, lienImage, "
									+ "typeReponse, Theme_idTheme FROM question";
	private final String SQL_GET_ALL_BY_THEME = "SELECT idQuestion, intitule, lienImage, "
									+ "typeReponse, Theme_idTheme FROM question "
									+ "WHERE Theme_idTheme = ?";
	private final String SQL_GET_BY_ID = "SELECT q.Theme_idTheme, q.idQuestion, q.intitule, q.lienImage, "
									+ "q.typeReponse, r.idReponse, r.libelleReponse, r.lienImage, "
									+ "r.position, r.isValid FROM question q "
									+ "INNER JOIN reponse r ON r.Question_idQuestion = q.idQuestion "
									+ "WHERE idQuestion  = ?";
	private final String INSERT_QUESTION = "INSERT INTO Question(intitule, lienImage, typeReponse, Theme_idTheme) "
									+ "VALUES(?,?,?,?)";
	private final String SELECT_MAX_ID = "SELECT MAX(idQuestion) FROM question";
	private final String DELETE_QUESTION = "DELETE FROM question WHERE idQuestion = ?";
	private final String UPDATE_QUESTION = "UPDATE question SET intitule = ?, lienImage = ?, "
									+ "typeReponse = ?, Theme_idTheme = ? "
									+ "WHERE idQuestion = ?";
	
	public QuestionDAOImpl() {
	
	}

	public static QuestionDAO getInstance() {
		if (instance == null) {
			instance = new QuestionDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Question> getAllQuestion() {

		List<Question> questions = new ArrayList<Question>();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_ALL_QUESTION);
			
			// execute la requete
			ResultSet rsQuestions = stmt.executeQuery();
			
			while(rsQuestions.next()){
				Question question = new Question();
				question.setIdQuestion(rsQuestions.getInt(1));
				question.setIntitule(rsQuestions.getString(2));
				question.setLienImage(rsQuestions.getString(3));
				question.setTypeReponse(rsQuestions.getString(4));
				question.setTheme(new Theme(rsQuestions.getInt(5)));
				
				questions.add(question);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}
	

	@Override
	public List<Question> getAllByTheme(int idTheme) {
		
		List<Question> questions = new ArrayList<Question>();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_ALL_BY_THEME);
			stmt.setInt(1, idTheme);
			// execute la requete
			ResultSet rsQuestions = stmt.executeQuery();
			
			while(rsQuestions.next()){
				Question question = new Question();
				question.setIdQuestion(rsQuestions.getInt(1));
				question.setIntitule(rsQuestions.getString(2));
				question.setLienImage(rsQuestions.getString(3));
				question.setTypeReponse(rsQuestions.getString(4));
				question.setTheme(new Theme(rsQuestions.getInt(5)));
				
				questions.add(question);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}

	@Override
	public Question getQuestionReponseById(int idQuestion) {
		Connection con = null;
		PreparedStatement stmt;
		int cpt = 0;
		Question question = null;
		Theme theme = null;
		List<Reponse> reponses = null;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idQuestion);
			
			// execute la requete
			ResultSet rsQuestion = stmt.executeQuery();
			
			while(rsQuestion.next()){
				if(cpt == 0){
					question = new Question();
					theme = new Theme(rsQuestion.getInt(1));
					question.setIdQuestion(rsQuestion.getInt(2));
					question.setIntitule(rsQuestion.getString(3));
					question.setLienImage(rsQuestion.getString(4));
					question.setTypeReponse(rsQuestion.getString(5));
					question.setTheme(theme);
					reponses = new ArrayList<Reponse>();
					cpt++;
				}
				Reponse reponse = new Reponse(rsQuestion.getInt(6));
				reponses.add(reponse);
				
			}
			
			question.setReponses(reponses);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public int deleteQuestion(int idQuestion) {
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(DELETE_QUESTION);
			stmt.setInt(1, idQuestion);
			// execute la requete
			
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Question pas supprimé");
				ok = 0;
			}else{
				System.out.println("Question supprimé");
				ok = 1;
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}
	
	@Override
	public int saveQuestion(Question question) {
		System.out.println("Je suis en insert !!");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_QUESTION);
			stmt.setString(1, question.getIntitule());
			stmt.setString(2, question.getLienImage());
			stmt.setString(3, question.getTypeReponse());
			stmt.setInt(4, question.getTheme().getIdTheme());
			
			// execute la requete
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Question pas inséré");
			}else{
				System.out.println("Question inséré");
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.getMaxIdQuestion();
	}

	@Override
	public void updateQuestion(Question question) {
		System.out.println("Je suis en update !");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(UPDATE_QUESTION);
			stmt.setString(1, question.getIntitule());
			stmt.setString(2, question.getLienImage());
			stmt.setString(3, question.getTypeReponse());
			stmt.setInt(4, question.getTheme().getIdTheme());
			stmt.setInt(5, question.getIdQuestion());
			
			// execute la requete
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Question pas updaté");
				ok = 0;
			}else{
				System.out.println("Question updaté");
				ok = 1;
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private int getMaxIdQuestion(){
		Connection con = null;
		PreparedStatement stmt;
		int res = -1;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SELECT_MAX_ID);
			
			// execute la requete
			ResultSet rsMax = stmt.executeQuery();
			
			res = rsMax.getInt(1);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
