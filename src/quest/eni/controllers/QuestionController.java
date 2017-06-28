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

import quest.eni.entities.Question;
import quest.eni.entities.Theme;
import quest.eni.resources.ReponseQuestionTheme;
import quest.eni.services.QuestionService;
import quest.eni.services.QuestionServiceImpl;
import quest.eni.services.ReponseService;
import quest.eni.services.ReponseServiceImpl;
import quest.eni.services.ThemeService;
import quest.eni.services.ThemeServiceImpl;

@Path("/question")
public class QuestionController {
	
private static QuestionService questionService = QuestionServiceImpl.getInstance();
private static ThemeService themeService = ThemeServiceImpl.getInstance();
private static ReponseService reponseService = ReponseServiceImpl.getInstance();
	
	@GET
	@Path("/nombre")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getNbQuestionByTheme() {
		
		//Initialisation des obj
		Response response;
//		List<Question> questions = questionService.getAllQuestion();
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
	@Path("/theme")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionsByTheme(@QueryParam("idTheme") int idTheme) {
		
		//Initialisation des obj
		Response response;
		List<Question> questions = questionService.getAllByTheme(idTheme);
		Theme theme = themeService.getThemeById(idTheme);
		ReponseQuestionTheme rep = new ReponseQuestionTheme(questions, theme);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(rep);
        
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
	public Response saveQuestionReponse(@FormParam("idQuestion") int idQuestion, 
			@FormParam("intitule") String intitule, 
			@FormParam("lienImage") String lienImage, 
			@FormParam("typeReponse") String typeReponse,
			@FormParam("idTheme") int idTheme,
			@FormParam("reponses") String reponses) {
		
		//Initialisation des obj
		Response response;
		Question question = new Question();
		question.setIdQuestion(idQuestion);
		question.setIntitule(intitule);
		question.setTypeReponse(typeReponse);
		question.setLienImage(lienImage);
		question.setTheme(new Theme(idTheme));

//		JSONObject recoData = new JSONObject(reponses);
		System.out.println("Question : " + question.toString());
		System.out.println(reponses);
//		int idInserted = questionService.saveQuestion(question);
//		System.out.println("Id inséré de la question : " + idInserted);
		
        Gson gson = new Gson();
                
        String json = gson.toJson("TOFOU");
        
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
	public Response editQuestion(@QueryParam("idQuestion") int idQuestion) {
		
		//Initialisation des obj
		Response response;
		Question question = questionService.getQuestionReponseById(idQuestion);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(question);
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
	public Response deleteQuestion(@QueryParam("idQuestion") int idQuestion) {
		
		//Initialisation des obj
		Response response;
		int resDelete = questionService.deleteQuestion(idQuestion);
		
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
//	
//	@POST
//	@Path("/save")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response saveQuestion(@QueryParam("idQuestion") int idQuestion, 
//			@QueryParam("libelleQuestion") String libelleQuestion, 
//			@QueryParam("description") String description) {
//		
//		//Initialisation des obj
//		Response response;
//		Question question = new Question();
//		question.setIdQuestion(idQuestion);
//		question.setLibelleQuestion(libelleQuestion);
//		question.setDescription(description);
//		
//		this.questionService.saveQuestion(question);
//		
//        Gson gson = new Gson();
//                
//        String json = gson.toJson("TODO");
//        response = Response.ok()
//        		.header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(json).build();
//        
//        return response;
//	}
	
}
