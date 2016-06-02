<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Post Page</title>
</head>
<body>

	<form name="blogpost" action="PostServlet" method="post">
	
		<p>Username: <input type="text" name="user"  placeholder="Please enter your username"> </p>
		
		<p> Date: <input type="text" name="date"  placeholder="Please enter the date"> </p>
		
		<p> Blog Post Title:<input type="text" name="title" placeholder="Please enter your title"> </p>
	
		<p> Please enter your blog post:</p>
		
		<textarea name="data" rows="10" cols="60"></textarea>
		
		<p><input type="Reset" value="Reset"> <input type="submit" value="Submit"></p>
	</form>

</body>
</html>
