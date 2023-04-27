

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
 * Servlet implementation class BankTransfer
 */
public class BankTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankTransfer() {
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
        String email=(String)Session.getAttribute("Email");	
		int pin=Integer.parseInt(request.getParameter("pin"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		String ifsc=(String)request.getParameter("ifsc");
		String bank=(String)request.getParameter("bank");
		long acco=Long.parseLong(request.getParameter("accono"));
		SmartTransaction smart=new SmartTransaction();
		int balance = 0;
		try {
			balance = smart.checkBanlance(email,pin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(balance==0)
		{
			Session.setAttribute("state", balance);
			response.sendRedirect("TransferMoney.jsp");
		}
		else if(amount>balance||balance==1000)
		{
			Session.setAttribute("insufficient", balance);
			response.sendRedirect("TransferMoney.jsp");
		}
		else if(balance!=1000)
		{
			try {
				
				int status=smart.BankTranfer(email,amount,ifsc,bank,acco);
				if(smart.BankTranfer(email,amount,ifsc,bank,acco)!=0)
				{
					Session.setAttribute("Status", status);
					response.sendRedirect("TransactionHistory.jsp");
				}
				else 
				{
					response.sendRedirect("TransactionHistory.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	}

}
