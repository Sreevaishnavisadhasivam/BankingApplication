package com.Banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountHolder
{
   public  long accono=0;
   public Connection con=Main.con;
   public long fetchAccono(String email) throws SQLException
   {
	   long accno=0;
	   String fetch="select accno from accountholder where email_id='"+email+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(fetch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
        {
			accno=rs.getLong(1);
        }
	 return accno;  
   }
   
   public ArrayList<Accountholderdetails> viewProfile(String email) throws SQLException
   {
	   ArrayList<Accountholderdetails>accodet=new ArrayList<>();
	   Accountholderdetails det=new Accountholderdetails();
	   long accno=fetchAccono(email);
	   String viewprofile="select * from accountholder where accno='"+accno+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(viewprofile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
        {
	       accodet.add(new Accountholderdetails(rs.getString(1),rs.getLong(2),rs.getString(3),0,rs.getString(5),rs.getString(6),0,0,0,rs.getLong(10),"null","null",rs.getString(13)));
        }
		return accodet;
	   
   }
   public void changePassword(String oldpassword,String newpassword,String email) throws SQLException
   {
	       long accno=fetchAccono(email);
 	       System.out.println(email+" ithu than id"+oldpassword+" "+newpassword);
 		   String oldpass="select md5(password) from userlogincredentails where email_id='"+email+"' and accno='"+accno+"'";
 		   Statement state=con.createStatement();
 		   ResultSet result=state.executeQuery(oldpass);
 		   if(result.next())
 		   {
 				  if(oldpassword.equals(newpassword))
 				  {
 					  System.out.println("password cannot be same as last password");
 				  }
 				  else
 				  {
 		          String changepass="update userlogincredentails set password=md5('"+newpassword+"') where email_id='"+email+"'";
 		          Statement changed=con.createStatement();
 		          int count=changed.executeUpdate(changepass);
 		          if(count!=0)
 		          {
 		        	  System.out.println("successfully changed your password");
 		          }

 		          }
 		   }
   }
   public ArrayList<Transaction> viewTransactionHistory(String email) throws SQLException
   {
	   ArrayList<Transaction>history=new ArrayList<>();
	   long accno=fetchAccono(email);
	   String query="select * from transaction where accno ='"+accno+"'"; 
	   Statement st=con.createStatement();
	   ResultSet rs=st.executeQuery(query);
	   int flag=0;
	   
	   while(rs.next())
	   {
		   history.add(new Transaction(rs.getInt(1),rs.getInt(2),rs.getLong(3),rs.getString(4),rs.getString(9),rs.getString(10)));
	   }
	    
	return history;
	   
   }

   
}
