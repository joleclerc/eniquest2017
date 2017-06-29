package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quest.eni.entities.Epreuve;
import quest.eni.entities.Section;

public class EpreuveDAOImpl implements EpreuveDAO{

	private static EpreuveDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_ALL_EPREUVE = "SELECT idEpreuve, nbrQuestion, dateCreation, "
									+ "libelleEpreuve, tempsEpreuve, typeEpreuve FROM epreuve";
	private final String SQL_GET_BY_ID = "SELECT e.nbrQuestion, e.dateCreation, e.libelleEpreuve, "
									+ "e.tempsEpreuve, e.typeEpreuve, s.idSection, s.idTheme FROM epreuve e LEFT OUTER JOIN "
									+ "section s ON s.idEpreuve = e.idEpreuve "
									+ "WHERE e.idEpreuve = ?";
	private final String DELETE_THEME = "DELETE FROM theme WHERE idTheme = ?";
	private final String INSERT_EPREUVE = "INSERT INTO epreuve(libelleEpreuve, tempsEpreuve, typeEpreuve)"
									+ "VALUES(?,?,?)";
	private final String UPDATE_THEME = "UPDATE THEME SET libelleTheme = ?, description = ? "
									+ "WHERE idTheme = ?";
	
	public EpreuveDAOImpl() {
	
	}

	public static EpreuveDAO getInstance() {
		if (instance == null) {
			instance = new EpreuveDAOImpl();
		}
		return instance;
	}

	@Override
	public void saveEpreuve(Epreuve epreuve) {
		System.out.println("Je suis en insert !!");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_EPREUVE);
			stmt.setString(1, epreuve.getLibelleEpreuve());
			stmt.setInt(2, epreuve.getTempsEpreuve());
			stmt.setString(3, epreuve.getTypeEpreuve());
			
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
		
	}

	@Override
	public List<Epreuve> getAllEpreuve() {

		List<Epreuve> epreuves = new ArrayList<Epreuve>();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_ALL_EPREUVE);
			
			// execute la requete
			ResultSet reEpreuves = stmt.executeQuery();
			
			while(reEpreuves.next()){
				Epreuve epreuve = new Epreuve();
				epreuve.setIdEpreuve(reEpreuves.getInt(1));
				epreuve.setNbrQuestion(reEpreuves.getInt(2));
				epreuve.setDateCreation(reEpreuves.getDate(3));
				epreuve.setLibelleEpreuve(reEpreuves.getString(4));
				epreuve.setTempsEpreuve(reEpreuves.getInt(5));
				epreuve.setTypeEpreuve(reEpreuves.getString(6));
				epreuves.add(epreuve);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return epreuves;
	}

	@Override
	public Epreuve getEpreuveDetailsById(int idEpreuve) {
		Connection con = null;
		PreparedStatement stmt;
		int cpt = 0;
		Epreuve epreuve = null;
		List<Section> sections = new ArrayList<Section>();
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idEpreuve);
			
			// execute la requete
			ResultSet rsEpreuve = stmt.executeQuery();
			
			while(rsEpreuve.next()){
				if(cpt == 0){
					epreuve = new Epreuve();
					System.out.println("New epreuve !");
//					theme = new Theme(rsQuestion.getInt(1));
					epreuve.setIdEpreuve(idEpreuve);
					epreuve.setNbrQuestion(rsEpreuve.getInt(1));
					epreuve.setDateCreation(rsEpreuve.getDate(2));
					epreuve.setLibelleEpreuve(rsEpreuve.getString(3));
					epreuve.setTempsEpreuve(rsEpreuve.getInt(4));
					epreuve.setTypeEpreuve(rsEpreuve.getString(5));
					cpt++;
				}
				int idSection = rsEpreuve.getInt(6);
				System.out.println("Id section : " + idSection);
				if(idSection != 0){
//					sections = new ArrayList<Section>();
					Section section = new Section(idSection);
					sections.add(section);
				}
				
			}
			epreuve.setSections(sections);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return epreuve;
	}
	
}
