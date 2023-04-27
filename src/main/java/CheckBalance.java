

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Banking.SmartTransaction;

/**
 * Servlet implementation class CheckBalance
 */
@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalance() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession Session = request.getSession();
        if(Session.getAttribute("Email")!=null)
        {
        String email=(String)Session.getAttribute("Email");	
		int pin=Integer.parseInt(request.getParameter("pin"));
		SmartTransaction smart=new SmartTransaction();
		try {
			int balance=smart.checkBanlance(email,pin);
			if(balance!=0)
			{
			Session.setAttribute("Balance", balance);
			response.sendRedirect("TransactionHistory.jsp");
			}
			else 
			{
			Session.setAttribute("invalid", balance);	
			response.sendRedirect("TransactionHistory.jsp");		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
	    }
	

	}
}
