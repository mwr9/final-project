package BlogDB;
import java.io.Serializable;

public class Blog implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String date;
	private String blogEntry;
	private String moderator;
	private String comments;
   
   public Blog(){
	   
   }

   public Blog(String userName, String date, String blogEntry, String moderator, String comments){
	  this.userName = userName;
	  this.date = date;
	  this.blogEntry = blogEntry;
	  this.moderator = moderator;
	  this.comments= comments;
   }
   
   
   public String getUserName(){
	return this.userName;   
   }
   
   public String getDate(){
	return this.date;	   
   }
   
   public String getBlogEntry(){
	return this.blogEntry;
   }
  
   public String getModerator(){
	return this.moderator;
   }
   
     
   public String getComments(){
	return this.comments;
   }
   
   
   
   public void setUserName(String userName){
	   this.userName = userName;
   }
   
   public void setDate(String date){
	   this.date = date;
   }
   
   public void setBlogEntry(String blogEntry){
	   this.blogEntry = blogEntry;
   }
   
   public void setModerator(String moderator){
	   this.moderator = moderator;
   }
   
     
   public void setComments(String comment){
	   this.comments = comment;
   }
   
}