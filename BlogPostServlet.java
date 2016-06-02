package SevenBlog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BlogPostServlet")
public class BlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BlogPostServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	PrintWriter out = response.getWriter();
	    	Connection conn = null;
	    	 
	        try{  
	        		 String uname = request.getParameter("userName");
	        		 String date = request.getParameter("date");  
	                 String title = request.getParameter("title");  
	                 String blog = request.getParameter("blog");  
	           
	                 String dbMode = "mysql";
	         		 String dbClassName = "com.mysql.jdbc.Driver";
	         		 String host = "mysql";
	         		 String db = "cms_ictg2";       
	         		 String dbusername = "cms-ictg2"; 
	         		 String dbpassword = "MarkChloe146!";
	         			
	         		 Class.forName(dbClassName); 
	         		 String DB_CONNSTRING = "jdbc:"+dbMode+"://" + host + "/" + db;
	         		 conn = DriverManager.getConnection(DB_CONNSTRING, dbusername, dbpassword);
	         	
	         	     PreparedStatement pst =(PreparedStatement) conn.prepareStatement("Insert into Blogs(userName,date,title,post) values(?,?,?,?)"); 

	                 pst.setString(1,uname);  
	                 pst.setString(2,date);        
	                 pst.setString(3,title);
	                 pst.setString(4,blog);
	                	                                
	                 int result = pst.executeUpdate();
	                                  
	                 String msg=" ";
	                 if(result!=0){  
	                   msg="Blog has been posted";
	                   out.println("<font size='6' color=blue>" + msg + "</font>");  
	                 }  
	                 else{  
	                   msg="Failed to post the blog";
	                   out.println("<font size='6' color=red>" + msg + "</font>");
	                  }  
	                 pst.close();
	               }  
	               catch (Exception e){  
	                 out.println(e);  
	               }  finally {
	       	    	if (conn != null){
	       		    	try {
	       					conn.close();
	       				} catch (SQLException e) {
	       					e.printStackTrace();
	       				}
	       		    	}
	       	    }
	 }

}
