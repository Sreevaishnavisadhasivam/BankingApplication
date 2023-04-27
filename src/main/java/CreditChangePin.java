

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.Banking.SmartTransaction;

/**
 * Servlet implementation class CreditChangePin
 */
@WebServlet("/CreditChangePin")
public class CreditChangePin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditChangePin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session = request.getSession();
        if(Session.getAttribute("Email")!=null)
        {
		String mail=(String)Session.getAttribute("Email");
		int pin=Integer.parseInt(request.getParameter("pin"));
		SmartTransaction smart=new SmartTransaction();
		try {
			if(smart.creditpin(mail, pin)!=0)
			{
				Session.setAttribute("creditpin",mail);
				response.sendRedirect("CreditChangePin.jsp");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        }	
	}

}
