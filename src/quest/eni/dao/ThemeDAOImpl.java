package quest.eni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import quest.eni.entities.Theme;

public class ThemeDAOImpl implements ThemeDAO{

	private static ThemeDAO instance;
	private static DAOFactory daoFactory = DAOFactory.getInstance();
	private final String SQL_GET_ALL_THEME = "SELECT idTheme, libelleTheme, description FROM theme";
	private final String SQL_GET_BY_ID = "SELECT libelleTheme, description FROM theme "
									+ "WHERE idTheme  = ?";
	private final String DELETE_THEME = "DELETE FROM theme WHERE idTheme = ?";
	private final String INSERT_THEME = "INSERT INTO THEME(libelleTheme, description) "
									+ "VALUE(?,?)";
	private final String UPDATE_THEME = "UPDATE THEME SET libelleTheme = ?, description = ? "
									+ "WHERE idTheme = ?";
	
	public ThemeDAOImpl() {
	
	}

	public static ThemeDAO getInstance() {
		if (instance == null) {
			instance = new ThemeDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Theme> getAllTheme() {

		List<Theme> themes = new ArrayList<Theme>();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_ALL_THEME);
			
			// execute la requete
			ResultSet rsThemes = stmt.executeQuery();
			
			while(rsThemes.next()){
				Theme theme = new Theme();
				theme.setIdTheme(rsThemes.getInt(1));
				theme.setLibelleTheme(rsThemes.getString(2));
				theme.setDescription(rsThemes.getString(3));
				themes.add(theme);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return themes;
	}

	@Override
	public Theme getThemeById(int idTheme) {
		Theme theme = new Theme();
		Connection con = null;
		PreparedStatement stmt;
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(SQL_GET_BY_ID);
			stmt.setInt(1, idTheme);
			
			// execute la requete
			ResultSet rsTheme = stmt.executeQuery();
			
			rsTheme.next();
			theme.setIdTheme(idTheme);
			theme.setLibelleTheme(rsTheme.getString(1));
			theme.setDescription(rsTheme.getString(2));

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theme;
	}

	@Override
	public int deleteTheme(int idTheme) {
		List<Theme> themes = new ArrayList<Theme>();
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(DELETE_THEME);
			stmt.setInt(1, idTheme);
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
	public void saveTheme(Theme theme) {
		System.out.println("Je suis en insert !!");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(INSERT_THEME);
			stmt.setString(1, theme.getLibelleTheme());
			stmt.setString(2, theme.getDescription());
			
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
	public void updateTheme(Theme theme) {
		System.out.println("Je suis en update !");
		Connection con = null;
		PreparedStatement stmt;
		int ok = -1; 
		
		try {
			con = daoFactory.getConnection();
			stmt = con.prepareStatement(UPDATE_THEME);
			stmt.setString(1, theme.getLibelleTheme());
			stmt.setString(2, theme.getDescription());
			stmt.setInt(3, theme.getIdTheme());
			
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
