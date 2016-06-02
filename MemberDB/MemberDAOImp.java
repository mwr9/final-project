package MemberDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAOImp implements MemberDAO{
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://mysql/cms_ictg2";
	   
	static final String DB_USER = "cms-ictg2";
	static final String DB_PASS = "MarkChloe146!";
	Connection conn;
	

	public MemberDAOImp(){
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	   
	
	@SuppressWarnings("unused")
	public ResultSet create(Member member){
		 String userName = member.getUserName();
		 String password = member.getPassword();
		 String firstName = member.getFirstName();
		 String lastName = member.getLastName();
		 String email = member.getEmail();
		 String phone = member.getPhone();
		 
		  ResultSet rs = null;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "INSERT INTO Members (userName, password, firstName, lastName, email, phone) VALUES (userName, firstName, MiddleName, lastName, email, phone)");
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		  return rs;
	}
	
	@SuppressWarnings("unused")
	public ResultSet update(Member member){
		String userName1 = member.getUserName();
		 String password = member.getPassword();
		 String firstName1 = member.getFirstName();
		 String lastName1 = member.getLastName();
		 String email1 = member.getEmail();
		 String phone1 = member.getPhone();
		 
		  ResultSet rs = null;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("UPDATE Members SET userName=userName1, password=password1, firstName=firstName1, lastName=lastName1, email=email1, phone=phone1)");
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		  return rs;
			
	}
	
	public void delete(Member member){
		  String userName = member.getUserName();
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				stmt.executeQuery( "DELETE FROM Members WHERE userName='" + userName + "'");
			    
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
	}
	
	public Member moveFirst(){
		return null;
		
	}
	 
	public Member moveLast(){
		return null;
		
	}
	 
	public Member moveNext(){
		return null;
		
	}
	 
	public Member movePrevious(){
		return null;
		
	}
	 
	public Member getCurrent(){
		return null;
		
	}
	
	
	public String getUserName(){
		  String userName="";
		  ResultSet rs;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "SELECT userName FROM Members");
			    while (rs.next() ) {
			        userName = rs.getString(1);  
			    }
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		return userName;
	}
	
   	public String getPassword() {
   		String password="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Members");
		    while (rs.next() ) {
		        password = rs.getString(2);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return password;
   	}
	
   	public String getFirstName(){
   		String firstName="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Members");
		    while (rs.next() ) {
		        firstName = rs.getString(3);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return firstName;
   	}
	   
	public String getLastName(){
   		String lastName="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Members");
		    while (rs.next() ) {
		        lastName = rs.getString(4);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return lastName;
   	}
	   
	public String getEmail(){
   		String email="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Members");
		    while (rs.next() ) {
		        email = rs.getString(4);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return email;
   	}
	   
	public String getPhone(){
   		String phoneNumber="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Members");
		    while (rs.next() ) {
		        phoneNumber = rs.getString(5);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return phoneNumber;
   	}
	   
		   
	public void setUserName(String userName){
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(userName) VALUES (" + userName + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   	}
	   
	public void setPassword(String password){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(firstName) VALUES (" + password + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setFirstName(String firstName){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(middleName) VALUES (" + firstName + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setLastName(String lastName){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(lastName) VALUES (" + lastName + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setEmail(String email){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(email) VALUES (" + email + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setPhone(String phone){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Members(phone) VALUES (" + phone + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	/**		 public Member moveFirst() {
    Member mBean = new Member();
    try {
       memberRowSet.first();
       mBean.setUserName(memberRowSet.getString("userName"));
       mBean.setFirstName(memberRowSet.getString("firstName"));
       mBean.setMiddleName(memberRowSet.getString("middleName"));
       mBean.setLastName(memberRowSet.getString("lastName"));
       mBean.setEmail(memberRowSet.getString("email"));
       mBean.setPhone(memberRowSet.getString("phone"));

    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return mBean;
 }

 public Member moveLast() {
    Member mBean = new Member();
    try {
       memberRowSet.last();
       mBean.setUserName(memberRowSet.getString("userName"));
       mBean.setFirstName(memberRowSet.getString("firstName"));
       mBean.setMiddleName(memberRowSet.getString("middleName"));
       mBean.setLastName(memberRowSet.getString("lastName"));
       mBean.setEmail(memberRowSet.getString("email"));
       mBean.setPhone(memberRowSet.getString("phone"));

    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return mBean;
 }

 public Member moveNext() {
    Member mBean = new Member();
    try {
       if (memberRowSet.next() == false)
          memberRowSet.previous();
       mBean.setUserName(memberRowSet.getString("userName"));
       mBean.setFirstName(memberRowSet.getString("firstName"));
       mBean.setMiddleName(memberRowSet.getString("middleName"));
       mBean.setLastName(memberRowSet.getString("lastName"));
       mBean.setEmail(memberRowSet.getString("email"));
       mBean.setPhone(memberRowSet.getString("phone"));

    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return mBean;
 }

 public Member movePrevious() {
    Member mBean = new Member();
    try {
       if (memberRowSet.previous() == false)
          memberRowSet.next();
       mBean.setUserName(memberRowSet.getString("userName"));
       mBean.setFirstName(memberRowSet.getString("firstName"));
       mBean.setMiddleName(memberRowSet.getString("middleName"));
       mBean.setLastName(memberRowSet.getString("lastName"));
       mBean.setEmail(memberRowSet.getString("email"));
       mBean.setPhone(memberRowSet.getString("phone"));

    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return mBean;
 }

 public Member getCurrent() {
    Member mBean = new Member();
    try {
       memberRowSet.moveToCurrentRow();
       mBean.setUserName(memberRowSet.getString("userName"));
       mBean.setFirstName(memberRowSet.getString("firstName"));
       mBean.setMiddleName(memberRowSet.getString("middleName"));
       mBean.setLastName(memberRowSet.getString("lastName"));
       mBean.setEmail(memberRowSet.getString("email"));
       mBean.setPhone(memberRowSet.getString("phone"));
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return mBean;
 }
*/	
	
}
