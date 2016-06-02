package SevenBlog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BlogReadServlet")
public class BlogReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogReadServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;

		try {
			
			String dbMode = "mysql";
			String dbClassName = "com.mysql.jdbc.Driver";
			String host = "mysql";
			String db = "cms_ictg2";
			String dbusername = "cms-ictg2";
			String dbpassword = "MarkChloe146!";

			Class.forName(dbClassName);
			String DB_CONNSTRING = "jdbc:" + dbMode + "://" + host + "/" + db;
			conn = DriverManager.getConnection(DB_CONNSTRING, dbusername, dbpassword);

			String blogdate="";
			String blogtitle="";
			String blogpost="";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT date, title, blogpost FROM Blogs sort by date desc");
			while (rs.next()) {
				blogdate = rs.getString("date");
				blogtitle = rs.getString("title");
				blogpost = rs.getString("blogpost");
			}
			
			HttpSession session = request.getSession();
	        session.setAttribute("date", blogdate);
	        session.setAttribute("title", blogtitle);
	        session.setAttribute("blogpost", blogpost);
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("getBlogs.jsp");
	        dispatcher.forward(request, response);
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
