package MemberDB;
import java.io.Serializable;

public class Member implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
   
   public Member(){
	   
   }

   public Member(String userName, String password, String firstName, String lastName, String email, String phone){
	  this.userName = userName;
	  this.password = password;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.email = email;
	  this.phone= phone;
   }
   
   
   public String getUserName(){
	return this.userName;   
   }
   
   public String getPassword(){
	return this.password;	   
   }
   
   public String getFirstName(){
	return this.firstName;
   }
  
   public String getLastName(){
	return this.lastName;
   }
   
   public String getEmail(){
	return this.email;
   }
   
   
   public String getPhone(){
	return this.phone;
   }
   
   
   
   public void setUserName(String userName){
	   this.userName = userName;
   }
   
   public void setFirstName(String firstName){
	   this.password = firstName;
   }
   
   public void setMiddleName(String middleName){
	   this.firstName = middleName;
   }
   
   public void setLastName(String lastName){
	   this.lastName = lastName;
   }
   
   public void setEmail(String email){
	   this.email = email;
   }
   
   public void setPhone(String phone){
	   this.phone = phone;
   }
   
}