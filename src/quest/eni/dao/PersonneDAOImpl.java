package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quest.eni.entities.Personne;

public class PersonneDAOImpl implements PersonneDAO{

	private static PersonneDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_VERIFY_USER = "SELECT COUNT(*) FROM personne "
										+ "WHERE identifiant = ? "
										+ "AND motdepasse = ?";
	
	private final String SQL_GET_PERSONNE = "SELECT * FROM personne "
										+ "WHERE identifiant = ?";
	
	private final String SQL_GET_FORMATEUR = "SELECT COUNT(*) FROM formateur ";
	
	private final String SQL_COUNT_PERSONNE = "SELECT COUNT(*) FROM personne ";
	
	public PersonneDAOImpl() {
	
	}

	public static PersonneDAO getInstance() {
		if (instance == null) {
			instance = new PersonneDAOImpl();
		}
		return instance;
	}

	@Override
	public boolean isValid(String login, String pw) {
		
		Connection con = null;
		PreparedStatement stmt;
		boolean resBool = false;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_VERIFY_USER);
			stmt.setString(1, login);
			stmt.setString(2, pw);
			
			// execute la requete
			ResultSet rsCount = stmt.executeQuery();
			
			rsCount.next();
			
			//Récupération des résultats
			int res = rsCount.getInt(1);
			if(res != 0)
				resBool = true;

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resBool;
	}

	@Override
	public Personne getPersonne(String login) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getNbPersonne() {
		
		Connection con = null;
		PreparedStatement stmt;
		int res = -1;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_COUNT_PERSONNE);
			
			// execute la requete
			ResultSet rsCount = stmt.executeQuery();
			
			rsCount.next();
			
			//Récupération des résultats
			res = rsCount.getInt(1);

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
