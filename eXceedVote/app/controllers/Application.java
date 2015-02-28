package controllers;




import play.*;  
import play.mvc.*;
import play.data.*;
import static play.data.Form.*; 
import views.html.*;
import models.*;

public class Application extends Controller {

    public static Result index() {
    	
    	
    		
    	
        return ok(index.render("5") );
    }
    public static Result login(){
    	return ok(login.render(Form.form(Login.class)));
    	
    }
    public static Result authenticate(){
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	if(loginForm.hasErrors()){
    		return badRequest(login.render(loginForm));
    		
    		
    	}else{
    		
    		session().clear();
    		session("Username",loginForm.get().Username);
    		return redirect(routes.Application.index());	
    			
    	}
    
    	
    }
    
    public static class Login{
    	public String Username;
    	public String Password;
   
    	public String validate(){
    		
    		if(Account.authenticate(Username,Password)==null){
    			
    			return "Invalid user or password";
    			
    			
    		}
    		
    		return null;
    		
    		
    	}
    	
    }

}
