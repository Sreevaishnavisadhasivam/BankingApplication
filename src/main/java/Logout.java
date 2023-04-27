import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Logout() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
          response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
          response.setDateHeader("Expires", 0);
		 HttpSession session = request.getSession();
	        if(session.getAttribute("Email")!= null)
	        {
	            session.setAttribute("Email",null);
	            response.sendRedirect("HomePage.jsp");
	        }
	        if(session.getAttribute("id")!= null)
	        {
	            session.setAttribute("id",null);
	            response.sendRedirect("HomePage.jsp");
	        }
	        if(session.getAttribute("adminid")!= null)
	        {
	            session.setAttribute("adminid",null);
	            response.sendRedirect("HomePage.jsp");
	        }
	}

}
