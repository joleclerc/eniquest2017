package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quest.eni.entities.Question;
import quest.eni.entities.Reponse;

public class ReponseDAOImpl implements ReponseDAO{

	private static ReponseDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_BY_ID = "SELECT r.libelleReponse, r.lienImage, "
									+ "r.position, r.isValid FROM reponse r "
									+ "WHERE idReponse  = ?";
	private final String SQL_GET_BY_QUESTION = "SELECT r.libelleReponse, r.lienImage, "
									+ "r.position, r.isValid, r.idReponse FROM reponse r "
									+ "WHERE Question_idQuestion  = ?";
	private final String INSERT_REPONSE = "INSERT INTO reponse(libelleReponse, lienImage, position, "
									+ " isValid, Question_idQuestion) VALUES (?,?,?,?,?)";
	private final String UPDATE_REPONSE = "UPDATE reponse "
									+ "SET libelleReponse = ?, lienImage = ?, position = ?, "
									+ "isValid = ? WHERE idReponse = ?";
	private final String DELETE_REPONSE = "DELETE FROM reponse "
									+ "WHERE Question_idQuestion = ?";
	
	public ReponseDAOImpl() {
	
	}

	public static ReponseDAO getInstance() {
		if (instance == null) {
			instance = new ReponseDAOImpl();
		}
		return instance;
	}

	@Override
	public Reponse getReponseByIdWithoutQuestion(int idReponse) {
		Reponse reponse = new Reponse();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idReponse);
			
			// execute la requete
			ResultSet rsReponse = stmt.executeQuery();
			
			rsReponse.next();
			reponse.setIdReponse(idReponse);
			reponse.setLibelleReponse(rsReponse.getString(1));
			reponse.setLienImage(rsReponse.getString(2));
			reponse.setPosition(rsReponse.getInt(3));
			reponse.setIsValid(rsReponse.getInt(4));

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reponse;
	}

	@Override
	public void insertReponse(Reponse reponse) {
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_REPONSE);
			stmt.setString(1, reponse.getLibelleReponse());
			stmt.setString(2, reponse.getLienImage());
			stmt.setInt(3, reponse.getPosition());
			stmt.setInt(4, reponse.getIsValid());
			stmt.setInt(5, reponse.getQuestion().getIdQuestion());
			
			// execute la requete
			boolean res = stmt.execute();

			if(res)
				System.out.println("Reponse KO");
			else
				System.out.println("Reponse OK");
			
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
	public void updateReponse(Reponse reponse) {
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(UPDATE_REPONSE);
			stmt.setString(1, reponse.getLibelleReponse());
			stmt.setString(2, reponse.getLienImage());
			stmt.setInt(3, reponse.getPosition());
			stmt.setInt(4, reponse.getIsValid());
			stmt.setInt(5, reponse.getIdReponse());
			
			// execute la requete
			boolean res = stmt.execute();

			if(res)
				System.out.println("Reponse KO");
			else
				System.out.println("Reponse OK");
			
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
	public List<Reponse> getReponseForQuestion(Question question) {
		List<Reponse> reponses = new ArrayList<Reponse>();
//		Reponse reponse = new Reponse();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_QUESTION);
			stmt.setInt(1, question.getIdQuestion());
			
			// execute la requete
			ResultSet rsReponse = stmt.executeQuery();
			
			while(rsReponse.next()){
				Reponse reponse = new Reponse();
				reponse.setLibelleReponse(rsReponse.getString(1));
				reponse.setLienImage(rsReponse.getString(2));
				reponse.setPosition(rsReponse.getInt(3));
				reponse.setIsValid(rsReponse.getInt(4));
				reponse.setIdReponse(rsReponse.getInt(5));
				reponses.add(reponse);
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reponses;
	}

	public void deleteReponse(int idQuestion) {
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(DELETE_REPONSE);
			stmt.setInt(1, idQuestion);
			
			// execute la requete
			boolean res = stmt.execute();

			if(res)
				System.out.println("Reponse not deleted");
			else
				System.out.println("Reponse deleted");
			
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
