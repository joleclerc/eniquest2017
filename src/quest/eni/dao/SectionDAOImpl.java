package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quest.eni.entities.Reponse;
import quest.eni.entities.Section;
import quest.eni.entities.Theme;

public class SectionDAOImpl implements SectionDAO{

	private static SectionDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_ALL_EPREUVE = "SELECT idTheme, libelleTheme, description FROM theme";
	private final String SQL_GET_BY_ID = "SELECT nbrQuestion, idTheme FROM section "
									+ "WHERE idSection  = ?";
	private final String DELETE_THEME = "DELETE FROM theme WHERE idTheme = ?";
	private final String INSERT_SECTION = "INSERT INTO section(nbrQuestion, idEpreuve, idTheme)"
									+ "VALUES(?,?,?)";
	private final String UPDATE_THEME = "UPDATE THEME SET libelleTheme = ?, description = ? "
									+ "WHERE idTheme = ?";
	
	public SectionDAOImpl() {
	
	}

	public static SectionDAO getInstance() {
		if (instance == null) {
			instance = new SectionDAOImpl();
		}
		return instance;
	}

	@Override
	public void saveSection(Section section) {
		System.out.println("Je suis en insert !!");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_SECTION);
			stmt.setInt(1, section.getNbrQuestion());
			stmt.setInt(2, section.getEpreuve().getIdEpreuve());
			stmt.setInt(3, section.getTheme().getIdTheme());
			
			// execute la requete
			boolean del = stmt.execute();
			
			if(del){
				System.out.println("Section pas inséré");
			}else{
				System.out.println("Section inséré");
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
	public Section getById(int idSection) {
		Section section = new Section();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idSection);
			
			// execute la requete
			ResultSet rsSection = stmt.executeQuery();
			
			rsSection.next();
			section.setIdSection(idSection);
			section.setNbrQuestion(rsSection.getInt(1));
			section.setTheme(new Theme(rsSection.getInt(2)));

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return section;

	}
	
}
