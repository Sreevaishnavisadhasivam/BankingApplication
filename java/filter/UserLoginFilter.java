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

@WebFilter("/Userlogin")
public class UserLoginFilter extends HttpFilter implements Filter {
       
    
    public UserLoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileno=request.getParameter("mobileno");
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(emailid);
	    if(matcher.matches())
	    {
	    	 regex="(0/91)?[7-9][0-9]{9}";
	         pattern = Pattern.compile(regex);
	         matcher = pattern.matcher(mobileno);
	         if(matcher.matches()) 
	         {
	           
	         }
	         else 
	 	      {
	 	    	System.out.println("mobile doingggg");
	 	    	HttpSession Session =request.getSession();
	 		   	Session.setAttribute("mobilefilter",mobileno);
	 	    	RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");  
	 	        rd.forward(request, response);
	 	        
	 	      }
	         
	    	chain.doFilter(request, response);  
	    }
	    else 
        {
       	 System.out.println(" email doingggg");
       	 HttpSession Session=request.getSession();
       	 Session.setAttribute("emailfilter",emailid );
       	 RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");  
	         rd.forward(request, response); 
	     }
	    
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
