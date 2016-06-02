package BlogDB;
import java.sql.ResultSet;
import java.util.List;

public class BlogController {
	
	   
	  
	   BlogDAO blogDAO; 
	   
	   
	   public BlogController() {
		   
		 blogDAO = new BlogDAOImp();
	   }
	   
	   public ResultSet createBlog(Blog blog) {
		  return blogDAO.createBlog(blog);
	   }

	   public List<Blog> getAllBlogs(){
		return null;
		   
	   }
	   
	   public Blog getBlog(String username){
		return null;
		   
	   }
	   public ResultSet updateBlog(Blog blog){
		   return blogDAO.updateBlog(blog);
	   }
	   
	   public void deleteBlog(Blog blog){
		   blogDAO.deleteBlog(blog);
	   }
	   
	   public List<Blog> getBlogsByTitle(String blogtitle){
		return null;
		   
	   }
	   	   	   
	}