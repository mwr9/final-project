package BlogDB;
import java.sql.ResultSet;
import java.util.List;

public interface BlogDAO {
	
		
		public ResultSet createBlog(Blog blog);
		
		public List<Blog> getAllBlogs();
		
		public Blog getBlog(String username);
		
		public ResultSet updateBlog(Blog blog);
		
		public void deleteBlog(Blog blog);
		
		public List<Blog> getBlogsByTitle(String blogtitle);
		
		 
		public String getUserName();
	
	   	public String getDate();
		   
		public String getBlogEntry();
		   
		public String getModerator();
		   
		public String getComments();
		   
				   
		   
		public void setUserName(String userName);
		   
		public void setDate(String firstName);
		   
		public void setBlogEntry(String middleName);
		   
		public void setModerator(String lastName);
		   
		public void setComments(String email);
		   
	}
