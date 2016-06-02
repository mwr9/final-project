package BlogDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOImp implements BlogDAO{
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://mysql/cms_ictg2";
	   
	static final String DB_USER = "cms-ictg2";
	static final String DB_PASS = "MarkChloe146!";
	Connection conn;
	List<Blog> blogs;

	public BlogDAOImp(){
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	   
	
	@SuppressWarnings("unused")
	public ResultSet createBlog(Blog blog){
		 String userName = blog.getUserName();
		 String date = blog.getDate();
		 String blogEntry = blog.getBlogEntry();
		 String moderator = blog.getModerator();
		 String comments = blog.getComments();
			 
		  ResultSet rs = null;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "INSERT INTO Blogs (userName, date, blogEntry, moderator, comments) VALUES (userName, date, blogEntry, moderator, comments)");
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		  return rs;
	}
	
	 public List<Blog> getAllBlogs() {
		  blogs = new ArrayList<Blog>();
		  Statement stmt = null;
		  ResultSet rs;
		  
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT blogpost FROM Blogs");
		    while (rs.next() ) {
		        Blog theBlog = this.getBlog(rs.getString(1));  
		    	blogs.add( theBlog );
		        }
		     
		  } catch (SQLException e1) {
			
				e1.printStackTrace();
		}
				
		 return blogs;    
	   }

	 public Blog getBlog(String username) {
		   Statement stmt = null;
		   ResultSet rs;
		   Blog theBlog = null;
			  
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "SELECT * FROM Blogs where userName=" + username);
			    while (rs.next() ) {
			    	String date = rs.getString(1);
			    	String title = rs.getString(2);
			    	String blogEntry = rs.getString(3);
			    	String blogid = rs.getString(4);
			    	String uid = rs.getString(5);
			    
			        theBlog = new Blog(date, title, blogEntry, blogid, uid);
			    }
			     
			  } catch (SQLException e1) {
				
					e1.printStackTrace();
			}
	      return theBlog;
	   }

	  	   
	  public List<Blog> getBlogsByTitle(String blogtitle){
		   Statement stmt = null;
		   ResultSet rs;
		   List<Blog> blogs = new ArrayList<Blog>();
			  
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "SELECT blogId FROM Blogs WHERE title like'%" + blogtitle + "%'");
				while (rs.next() ) {
			       Blog theBlog = this.getBlog(rs.getString(1));  
			    	blogs.add(theBlog);
			        }
			     
			  } catch (SQLException e1) {
				
					e1.printStackTrace();
			}
	      return blogs;
	   }
		   
	   
	
	@SuppressWarnings("unused")
	public ResultSet updateBlog(Blog blog){
		 String userName = blog.getUserName();
		 String date = blog.getDate();
		 String blogEntry = blog.getBlogEntry();
		 String moderator = blog.getModerator();
		 String comments = blog.getComments();
		 
		  ResultSet rs = null;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("UPDATE Blogs SET userName=userName, date=date, blogEntry=blogEntry, moderator=moderator, comments=comments)");
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		  return rs;
			
	}
	
	public void deleteBlog(Blog blog){
		  String userName = blog.getUserName();
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				stmt.executeQuery( "DELETE FROM Blogs WHERE userName='" + userName + "'");
			    
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
	}
	
		
	public String getUserName(){
		  String userName="";
		  ResultSet rs;
		  Statement stmt = null;
		  try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery( "SELECT userName FROM Blogs");
			    while (rs.next() ) {
			        userName = rs.getString(1);  
			    }
		  } catch (SQLException e1) {
						e1.printStackTrace();
		  }
		return userName;
	}
	
   	public String getDate() {
   		String firstName="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Blogs");
		    while (rs.next() ) {
		        firstName = rs.getString(2);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return firstName;
   	}
	
   	public String getBlogEntry(){
   		String middleName="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Blogs");
		    while (rs.next() ) {
		        middleName = rs.getString(3);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return middleName;
   	}
	   
	public String getModerator(){
   		String lastName="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Blogs");
		    while (rs.next() ) {
		        lastName = rs.getString(4);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return lastName;
   	}
	   
	public String getComments(){
   		String email="";
   		ResultSet rs;
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT userName FROM Blogs");
		    while (rs.next() ) {
		        email = rs.getString(5);  
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   		return email;
   	}
	   
		   
		   
	public void setUserName(String userName){
   		Statement stmt = null;
   		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Blogs(userName) VALUES (" + userName + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
   	}
	   
	public void setDate(String date){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Blogs(date) VALUES (" + date + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setBlogEntry(String blogEntry){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Blogs(blogEntry) VALUES (" + blogEntry + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setModerator(String moderator){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Blogs(moderator) VALUES (" + moderator + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	public void setComments(String comments){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery( "INSERT INTO Blogs(comments) VALUES (" + comments + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	   
	
	}

