package SevenBlog;



import java.io.IOException;

import java.io.PrintWriter;
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
 
              
        // get reCAPTCHA request param
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
 
                
        if (verify) {
            response.sendRedirect("LoginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>The Captcha could not be verified. Please try again.</font>");
            rd.include(request, response);
        }
    }
}
