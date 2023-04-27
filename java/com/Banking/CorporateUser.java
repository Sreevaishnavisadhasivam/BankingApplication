package com.Banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class CorporateUser 
{
  public Connection con=Main.con;
  
  public ArrayList<CorperateUserdet> viewProfile(String adminid) throws SQLException
  {
	  ArrayList<CorperateUserdet> corpdet=new ArrayList<>();
	  String profile="select * from branch_admin where branch_admin_id='"+adminid+"'";
	  Statement state = null;
		try {
			state = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ResultSet rs = null;
		try {
			rs = state.executeQuery(profile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
			corpdet.add(new CorperateUserdet(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getString(7)));
		}
	  return corpdet;
  }
  public ArrayList<Service> viewServices() throws Exception
  {
	  Service service=new Service(); 
	  ArrayList<Service>servicelist=new ArrayList<>();
	  String status="applied";
	  String viewservice="select * from service where status = '"+status+"'";
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery(viewservice);
	  while(rs.next())
	  {
		 servicelist.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
	  }	  
	  return servicelist;
  }
  
  public  ArrayList<Service> verifyService(String id) throws SQLException
  {
	  Service service=new Service(); 
	  ArrayList<Service>servicelist=new ArrayList<>();
	  String appstatus="applied";
	  String selectquery="select * from service,bank where status='"+appstatus+"'and bank.bank_id=service.bank_id and bank_head_id='"+id+"' ";
	  Statement state = null;
		try {
			state = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ResultSet rs = null;
		try {
			rs = state.executeQuery(selectquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(rs.next())
		  {
			 servicelist.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
		  }	
		System.out.println("hdvyge");
		return servicelist;
  }

  
  public void accept(int service_id) throws Exception
  {
	  SmartTransaction smart=new SmartTransaction();
	  String service="select service_type,accno,service_description from service where service_id='"+service_id+"'";
	  Statement sta=con.createStatement();
      ResultSet rs=sta.executeQuery(service);
      if(rs.next())
      {
    	  String type=rs.getString(1);
    	  long accono=rs.getLong(2);
    	  String desc=rs.getString(3);
    	  if(type.equals("atm application"))
    	   {
    		  smart.apply(service_id,accono);
    		  smart.atmupdate(accono);
    	   }
    	   if(type.equals("credit application"))
    	   {
    		   smart.apply(service_id,accono);
    		   smart.creditupdate(accono);
    	   }
    	   if (type.equals("debit application"))
    	   {
    			smart.apply(service_id, accono);
    			smart.debitupdate(accono);
    	   }
    	   if(type.equals("net banking application"))
    	   {
    	  		smart.apply(service_id, accono);	
    	  		smart.Netbankingservice(accono, desc, service_id);
    	   }
    	   if(type.equals("change address application"))
    	   {
    		    smart.apply(service_id, accono);   
    	  		smart.changeAddressservice(accono, desc, service_id);	
    	   }
    	   if(type.equals("ATM block application"))
    	   {
    	  	 smart.blockservice(accono, type);		 
    	   }
    	   if(type.equals("credit block application"))
    	   {
    	  		smart.blockservice(accono, type);	 
    	   }
    	   if(type.equals("debit block application"))
    	   {
    	  		smart.blockservice(accono, type);	 
    	   }
    	  		
      }
  }
  public void decline(int service_id) throws SQLException
  {
	     String status="declined";
         String apply="update service set status='"+status+"' where service_id='"+service_id+"'";
		 Statement sta=con.createStatement();
		 int count=sta.executeUpdate(apply);
		 if(count!=0)
		 {
			System.out.println("done successfully"); 
		 }
		 else 
		 {
			 System.out.println("something went wrong");
		 }
  }
  
  public void changePassword(String oldpassword,String newpassword,String id) throws SQLException
  {
	       System.out.println(id+" ithu than id"+oldpassword+" "+newpassword);
		   String oldpass="select md5(password) from branch_admin_login_credentials where adminid='"+id+"'";
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
		          String changepass="update branch_admin_login_credentials set password=md5('"+newpassword+"') where adminid='"+id+"'";
		          Statement changed=con.createStatement();
		          int count=changed.executeUpdate(changepass);
		          if(count!=0)
		          {
		        	  System.out.println("successfully changed your password");
		          }

		          }
		   }
	  
  }
  
public int addAccount(String name,String address,String type,long mobile,String email,String id) throws SQLException
{
String bankidentity="";
String newaccono="";
String branch="";
String bankid="select branch_bank_id,branch from branch_admin where branch_admin_id='"+id+"'"; 
Statement st=con.createStatement();
ResultSet set=st.executeQuery(bankid);
while(set.next())
{
bankidentity=set.getString(1);
branch=set.getString(2);
break;
}
String accno="SELECT  MAX(accno) FROM accountholder";
Statement st1=con.createStatement();
ResultSet set1=st1.executeQuery(accno);
while(set1.next())
{
newaccono=set1.getString(1);
break;
}
long newacco1=Long.parseLong(newaccono)+1;
newaccono=Long.toString(newacco1);
int passed=0;
while(passed!=1)
{
passed=1;
String addaccount="insert into accountholder(holdername,address,acctype,mobile,bank_id,accno,balance,branch,email_id)values('"+name+"','"+address+"','"+type+"','"+mobile+"','"+bankidentity+"','"+newacco1+"',2000,'"+branch+"','"+email+"')";
Statement st2=con.createStatement();
int c=st2.executeUpdate(addaccount);
System.out.println("account added successfully");
String userlogin="insert into userlogincredentails(username,password,mobileno,accno,email_id)values('"+name+"',md5('"+mobile+"'),'"+mobile+"','"+newaccono+"','"+email+"')";
Statement st3=con.createStatement();
int count=st3.executeUpdate(userlogin);
if(count!=0)
{
	System.out.println("user credetials added successfully");
}
}
return passed;
}

}
