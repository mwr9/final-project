package ourblog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	//	throw new ServletException("Servlet " + getClass().getName() + " does not accept the GET method. Use POST method.");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PrintWriter out = response.getWriter(); 
				
		try{
			String dbMode = "mysql";
			String dbClassName = "com.mysql.jdbc.Driver";
			String host = "mysql";
						
			String db = "cms_ictg2";       
			String username = "cms-ictg2"; 
			String password = "MarkChloe146!";
			
			Class.forName(dbClassName);
			String DB_CONNSTRING = "jdbc:"+dbMode+"://" + host + "/" + db;
			conn = DriverManager.getConnection(DB_CONNSTRING, username, password);
		        	
        	String uName= request.getParameter("username");
        	String sql = "SELECT  * FROM Members WHERE userName=?" ;
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,uName);
        	ResultSet rs = stmt.executeQuery();
           
            if(rs.first()){
                out.print("False");
           }else{
                out.print("True");
           }
        }catch (SQLException | ClassNotFoundException  ex){
        	ex.printStackTrace();  
        }finally {
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
