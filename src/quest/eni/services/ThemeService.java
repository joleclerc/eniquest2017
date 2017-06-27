package quest.eni.services;

import java.util.List;

import quest.eni.entities.Theme;

public interface ThemeService {

	public List<Theme> getAllTheme();
	
	public void saveTheme(Theme theme);
	
	public Theme getThemeById(int idTheme);
	
	public int deleteTheme(int idTheme);
	
}
