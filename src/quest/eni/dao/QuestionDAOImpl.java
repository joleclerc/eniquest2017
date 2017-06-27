package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import quest.eni.entities.Question;
import quest.eni.entities.Theme;

public class QuestionDAOImpl implements QuestionDAO{

	private static QuestionDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_ALL_QUESTION = "SELECT idQuestion, intitule, lienImage, "
									+ "typeReponse, Theme_idTheme FROM question";
	private final String SQL_GET_BY_ID = "SELECT libelleQuestion, description FROM Question "
									+ "WHERE idQuestion  = ?";
	private final String DELETE_QUESTION = "DELETE FROM Question WHERE idQuestion = ?";
	private final String INSERT_QUESTION = "INSERT INTO Question(libelleQuestion, description) "
									+ "VALUE(?,?)";
	private final String UPDATE_QUESTION = "UPDATE Question SET libelleQuestion = ?, description = ? "
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
	public Question getQuestionById(int idQuestion) {
		Question Question = new Question();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idQuestion);
			
			// execute la requete
			ResultSet rsQuestion = stmt.executeQuery();
			
			rsQuestion.next();
			Question.setIdQuestion(idQuestion);
			Question.setLibelleQuestion(rsQuestion.getString(1));
			Question.setDescription(rsQuestion.getString(2));

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Question;
	}

	@Override
	public int deleteQuestion(int idQuestion) {
		List<Question> Questions = new ArrayList<Question>();
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(DELETE_Question);
			stmt.setInt(1, idQuestion);
			// execute la requete
			
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Thème pas supprimé");
				ok = 0;
			}else{
				System.out.println("Thème supprimé");
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
	public void saveQuestion(Question Question) {
		System.out.println("Je suis en insert !!");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_Question);
			stmt.setString(1, Question.getLibelleQuestion());
			stmt.setString(2, Question.getDescription());
			
			// execute la requete
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Thème pas inséré");
				ok = 0;
			}else{
				System.out.println("Thème inséré");
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

	@Override
	public void updateQuestion(Question Question) {
		System.out.println("Je suis en update !");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(UPDATE_Question);
			stmt.setString(1, Question.getLibelleQuestion());
			stmt.setString(2, Question.getDescription());
			stmt.setInt(3, Question.getIdQuestion());
			
			// execute la requete
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Thème pas updaté");
				ok = 0;
			}else{
				System.out.println("Thème updaté");
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
	
}
