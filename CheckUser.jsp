<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    
		Connection conn = null;

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
	
	        	
        	String userName= request.getParameter("username");
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT  * FROM Members WHERE userName=" + userName);
           
            if(rs.first()){
                out.print("False");
           }else{
                out.print("True");
           }
        }catch (SQLException  ex){
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
%>

</body>
</html>