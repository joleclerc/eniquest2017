package quest.eni.dao;

import java.util.List;

import quest.eni.entities.Theme;

public interface ThemeDAO {

	public List<Theme> getAllTheme();
	
	public void saveTheme(Theme theme);
	
	public Theme getThemeById(int idTheme);
	
	public int deleteTheme(int idTheme);
	
	public void updateTheme(Theme theme);
	
}
