package Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet Filter implementation class TransferMoneyFilter
 */
@WebFilter("/BankTransfer")
public class TransferMoneyFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TransferMoneyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pin=request.getParameter("pin");
		String amount=request.getParameter("amount");
		String bank=request.getParameter("bank");
		String acco=request.getParameter("accono");
		String regex = "^[0-9]{4,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pin);
		if(matcher.matches()) 
	    {
			regex = "^[0-9]+$";
	         pattern = Pattern.compile(regex);
	         matcher = pattern.matcher(acco);
	         if(matcher.matches()) {
	           
	        	 regex="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		         pattern = Pattern.compile(regex);
		         matcher = pattern.matcher(bank);
		         if(matcher.matches()) {
		            
		        	 
		        	 regex = "^[0-9]{0,3}.?[0-9]{1}$";
			 		 pattern = Pattern.compile(regex);
			 		 matcher = pattern.matcher(amount);
			 		 if(matcher.matches()) {
			            
			         }
			         else
			         {
			        	  HttpSession Session=request.getSession();
				          Session.setAttribute("amountfilter",pin);
				          RequestDispatcher rd=request.getRequestDispatcher("TransferMoney.jsp");  
				 	      rd.forward(request, response);  
			         }
		         }
		         else
		         {
		        	  HttpSession Session=request.getSession();
			          Session.setAttribute("bankfilter",pin);
			          RequestDispatcher rd=request.getRequestDispatcher("TransferMoney.jsp");  
			 	      rd.forward(request, response);  
		         }
	         }
	         else
	         {
	        	 HttpSession Session=request.getSession();
		          Session.setAttribute("accountfilter",pin);
		          RequestDispatcher rd=request.getRequestDispatcher("TransferMoney.jsp");  
		 	      rd.forward(request, response);  
	         }
	    }
		else 
		{
			  HttpSession Session=request.getSession();
	          Session.setAttribute("pinfilter",pin);
	          RequestDispatcher rd=request.getRequestDispatcher("TransferMoney.jsp");  
	 	      rd.forward(request, response); 
		}
	 
	     
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
