import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Banking.AccountHolder;
import com.Banking.Accountholderdetails;
import com.Banking.HolderCredentials;
import com.Banking.Main;

@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Connection con=Main.con;
    public Userlogin() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		long mobileno=Long.parseLong(request.getParameter("mobileno"));
		String query="select * from userlogincredentails u,accountholder a where u.email_id='"+emailid+"'and u.password=md5('"+password+"') and a.mobile='"+mobileno+"' and u.mobileno='"+mobileno+"' and u.accno=a.accno";
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next())
			{
				HttpSession Session = request.getSession();
			   	Session.setAttribute("Email",emailid);
			   	response.sendRedirect("UserHome.jsp");
			}

					else 
					{
						HttpSession Session = request.getSession();
					    Session.setAttribute("failed",emailid);
						response.sendRedirect("UserLogin.jsp");
					}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}
