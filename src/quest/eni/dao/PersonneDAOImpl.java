package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Form;

import quest.eni.entities.Formateur;
import quest.eni.entities.Personne;
import quest.eni.entities.Stagiaire;

public class PersonneDAOImpl implements PersonneDAO{

	private static PersonneDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_VERIFY_USER = "SELECT COUNT(*) FROM personne "
										+ "WHERE identifiant = ? "
										+ "AND motdepasse = ?";
	
	private final String SQL_GET_PERSONNE = "SELECT * FROM personne "
										+ "WHERE identifiant = ?";
	
	private final String SQL_GET_NB_FORMATEUR = "SELECT COUNT(*) FROM formateur f INNER JOIN personne p "
										+ "ON f.Personne_idPersonne = p.idPersonne "
										+ "WHERE p.identifiant = ?";
	
	private final String SQL_GET_FORMATEUR = "SELECT f.idFormateur, p.idPersonne, p.identifiant, p.motdepasse, "
										+ "p.nom, p.prenom, p.dob, p.emailPerso, p.emailENI, "
										+ "p.telephone, p.adresse, p.dateInscription "
										+ "FROM formateur f INNER JOIN personne p "
										+ "ON f.Personne_idPersonne = p.idPersonne "
										+ "WHERE p.identifiant = ?";
	
	private final String SQL_GET_STAGIAIRE = "SELECT s.idStagiaire, p.idPersonne, p.identifiant, p.motdepasse, "
										+ "p.nom, p.prenom, p.dob, p.emailPerso, p.emailENI, "
										+ "p.telephone, p.adresse, p.dateInscription "
										+ "FROM stagiaire s INNER JOIN personne p "
										+ "ON s.Personne_idPersonne = p.idPersonne "
										+ "WHERE p.identifiant = ?";
	
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

	@Override
	public Personne getStagOrForm(String login) {
		
		Connection con = null;
		PreparedStatement stmt;
		int res = -1;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_NB_FORMATEUR);
			stmt.setString(1, login);
			
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
		
		if(res > 0){
			try {
				
				con = daoFactory.getConnection();
				stmt = con.prepareStatement(SQL_GET_FORMATEUR);
				stmt.setString(1, login);
				
				// execute la requete
				ResultSet rsFormateur = stmt.executeQuery();
				
				rsFormateur.next();

				//Récupération des résultats
				Personne formateur = new Formateur(rsFormateur.getInt(1));
				formateur.setIdPersonne(rsFormateur.getInt(2));
				formateur.setIdentifiant(rsFormateur.getString(3));
				formateur.setMotDePasse(rsFormateur.getString(4));
				formateur.setNom(rsFormateur.getString(5));
				formateur.setPrenom(rsFormateur.getString(6));
				formateur.setDob(rsFormateur.getDate(7));
				formateur.setEmailPerso(rsFormateur.getString(8));
				formateur.setEmailENI(rsFormateur.getString(9));
				formateur.setTelephone(rsFormateur.getString(10));
				formateur.setAdresse(rsFormateur.getString(11));
				formateur.setDateInscription(rsFormateur.getDate(12));

				con.close();
				
				return formateur;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				
				con = daoFactory.getConnection();
				stmt = con.prepareStatement(SQL_GET_STAGIAIRE);
				stmt.setString(1, login);
				
				// execute la requete
				ResultSet rsStagiaire = stmt.executeQuery();
				
				rsStagiaire.next();

				//Récupération des résultats
				Personne stagiaire = new Stagiaire(rsStagiaire.getInt(1));
				stagiaire.setIdPersonne(rsStagiaire.getInt(2));
				stagiaire.setIdentifiant(rsStagiaire.getString(3));
				stagiaire.setMotDePasse(rsStagiaire.getString(4));
				stagiaire.setNom(rsStagiaire.getString(5));
				stagiaire.setPrenom(rsStagiaire.getString(6));
				stagiaire.setDob(rsStagiaire.getDate(7));
				stagiaire.setEmailPerso(rsStagiaire.getString(8));
				stagiaire.setEmailENI(rsStagiaire.getString(9));
				stagiaire.setTelephone(rsStagiaire.getString(10));
				stagiaire.setAdresse(rsStagiaire.getString(11));
				stagiaire.setDateInscription(rsStagiaire.getDate(12));

				con.close();
				
				return stagiaire;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}
	
	
	
}
