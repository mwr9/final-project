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
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection) DriverManager.getConnection("jdbc:mysql://mysql/cms_ictg2", "cms-ictg2", "MarkChloe146!");
        	
        	String userName= request.getParameter("username");
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT  * FROM Members WHERE username=" + userName);
           
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