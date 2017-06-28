package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quest.eni.entities.Reponse;
import quest.eni.entities.Theme;

public class ReponseDAOImpl implements ReponseDAO{

	private static ReponseDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_BY_ID = "SELECT r.libelleReponse, r.lienImage, "
									+ "r.position, r.isValid FROM reponse r "
									+ "WHERE idReponse  = ?";
	private final String INSERT_REPONSE = "INSERT INTO reponse(libelleReponse, lienImage, position, "
									+ " isValid) VALUES (?,?,?,?)";
	private final String UPDATE_REPONSE = "UPDATE reponse "
									+ "SET libelleReponse = ?, lienImage = ?, position = ?, "
									+ "isValid = ? WHERE idReponse = ?";
	
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

}
