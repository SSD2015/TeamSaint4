package models;
import javax.persistence.*;

import play.*;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;

@Entity
public class Account extends Model {
	
@Id
	public Long ID;
	public String Username;
	public String Password;
	public int type;
	public static Finder<Long,Account> find=new Finder<Long,Account>(Long.class,Account.class);

	public static Account authenticate(String Username,String Password){
		
		
		
		return Account.find.where().eq("Username", Username).eq("Password" , Password).findUnique();
		
	}
	
}
