package quest.eni.controllers;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import quest.eni.entities.Theme;
import quest.eni.services.ThemeService;
import quest.eni.services.ThemeServiceImpl;

@Path("/themes")
public class ThemeController {
	
	private static ThemeService themeService = ThemeServiceImpl.getInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllTheme() {
		
		//Initialisation des obj
		Response response;
		List<Theme> themes = themeService.getAllTheme();
		
        Gson gson = new Gson();
                
        String json = gson.toJson(themes);
        
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
	@GET
	@Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
	public Response editTheme(@QueryParam("idTheme") int idTheme) {
		
		//Initialisation des obj
		Response response;
		Theme theme = themeService.getThemeById(idTheme);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(theme);
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
	
	@GET
	@Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
	public Response deleteTheme(@QueryParam("idTheme") int idTheme) {
		
		//Initialisation des obj
		Response response;
		int resDelete = themeService.deleteTheme(idTheme);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(resDelete);
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
	@POST
	@Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
	public Response saveTheme(@FormParam("idTheme") int idTheme, 
			@FormParam("libelleTheme") String libelleTheme, 
			@FormParam("description") String description) {
		
		//Initialisation des obj
		Response response;
		Theme theme = new Theme();
		theme.setIdTheme(idTheme);
		theme.setLibelleTheme(libelleTheme);
		theme.setDescription(description);
		System.out.println(theme.toString());
		
		themeService.saveTheme(theme);
		
        Gson gson = new Gson();
                
        String json = gson.toJson("MODIFICATIONS EFFECTUEES !!!");
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
	
}
