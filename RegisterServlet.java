package SevenBlog;



import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
 
    private static final long serialVersionUID = -6506682026701304964L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	 Connection conn = null;
    	 
        // get reCAPTCHA request param
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
 
                
        if (verify) {

        	 try{  
        		 String uname = request.getParameter("userName");
        		 String fname = request.getParameter("firstName");  
                 String lname = request.getParameter("lastName");  
                 String email = request.getParameter("email");  
                 String password = request.getParameter("password");  
                 

                 String dbMode = "mysql";
         		 String dbClassName = "com.mysql.jdbc.Driver";
         		 String host = "mysql";
         		 String db = "cms_ictg2";       
         		 String dbusername = "cms-ictg2"; 
         		 String dbpassword = "MarkChloe146!";
         			
         		 Class.forName(dbClassName); 
         		 String DB_CONNSTRING = "jdbc:"+dbMode+"://" + host + "/" + db;
         		 conn = DriverManager.getConnection(DB_CONNSTRING, dbusername, dbpassword);
         	
         	     PreparedStatement pst =(PreparedStatement) conn.prepareStatement("Insert into Members(userName, firstName,lastName,email,password) values(?,?,?,?,?)"); 

                 pst.setString(1,uname);  
                 pst.setString(2,fname);        
                 pst.setString(3,lname);
                 pst.setString(4,email);
                 pst.setString(5,password);
                                
                 int result = pst.executeUpdate();
                                  
                 String msg=" ";
                 if(result!=0){  
                   msg="Record has been inserted";
                   out.println("<font size='6' color=blue>" + msg + "</font>");  
                 }  
                 else{  
                   msg="failed to insert the data";
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

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
            out.println("<font color=red>The Captcha could not be verified. Please try again.</font>");
            rd.include(request, response);
        } 
}
}
