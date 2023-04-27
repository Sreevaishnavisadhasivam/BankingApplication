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
 * Servlet Filter implementation class CreditChangePinFilter
 */
@WebFilter("/CreditChangePin")
public class CreditChangePinFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public CreditChangePinFilter() {
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
		String repin=request.getParameter("repin");
		String regex = "^[0-9]{4,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pin);
		if(matcher.matches()) 
	    {
			
	    }
		else 
		{
			  HttpSession Session=request.getSession();
	          Session.setAttribute("pinfilter",pin);
	          RequestDispatcher rd=request.getRequestDispatcher("CreditChangePin.jsp");  
	 	      rd.forward(request, response); 
		}
		if(pin.equals(repin))
		{
			
		}
		else 
		{
			  HttpSession Session=request.getSession();
	          Session.setAttribute("pinfilter",pin);
	          RequestDispatcher rd=request.getRequestDispatcher("CreditChangePin.jsp");  
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
