package MemberDB;
import java.sql.ResultSet;

public interface MemberDAO {
	
		
		public ResultSet create(Member member);
		
		public ResultSet update(Member member);
		
		public void delete(Member member);
		
		public Member moveFirst();
		 
		public Member moveLast() ;
		 
		public Member moveNext();
		 
		public Member movePrevious();
		 
		public Member getCurrent();
		
		 
		public String getUserName();
	
	   	public String getFirstName();
		   
		public String getPassword();
		   
		public String getLastName();
		   
		public String getEmail();
		   
		public String getPhone();
		   
		   
		public void setUserName(String userName);
		   
		public void setFirstName(String firstName);
		   
		public void setPassword(String password);
		   
		public void setLastName(String lastName);
		   
		public void setEmail(String email);
		   
		public void setPhone(String phone);

}
