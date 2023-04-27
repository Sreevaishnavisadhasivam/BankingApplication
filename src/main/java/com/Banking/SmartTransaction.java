package com.Banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class SmartTransaction
{
   public Connection con=Main.con;
   public ArrayList<AtmCard> atmService(String email) throws SQLException
   {
	   ArrayList<AtmCard>atm=new ArrayList<>();
	   long acco=fetchAccono(email);
	   String query="select * from atmcard where accno='"+acco+"' ";
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
		if(rs.next())
        {
			atm.add(new AtmCard(rs.getInt(1),rs.getLong(2),rs.getInt(3),rs.getString(4)));
        }
		return atm;
   }
   public ArrayList<CreditCard> creditService(String email) throws SQLException
   {
	   ArrayList<CreditCard>atm=new ArrayList<CreditCard>();
	   long acco=fetchAccono(email);
	   String query="select * from creditcard where accno='"+acco+"' ";
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
		if(rs.next())
        {
			atm.add(new CreditCard(rs.getInt(1),rs.getLong(2),rs.getInt(3),rs.getString(4)));
        }
		return atm;
   }
   
   public ArrayList<DebitCard> debitService(String email) throws SQLException
   {
	   ArrayList<DebitCard>atm=new ArrayList<>();
	   long acco=fetchAccono(email);
	   String query="select * from debitcard where accno='"+acco+"' ";
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
		if(rs.next())
        {
			atm.add(new DebitCard(rs.getInt(1),rs.getLong(2),rs.getInt(3),rs.getString(4)));
        }
		return atm;
   }
   public ArrayList<NetBanking> netbankingService(String email) throws SQLException
   {
	   ArrayList<NetBanking>atm=new ArrayList<>();
	   long acco=fetchAccono(email);
	   String query="select * from netbanking where accno='"+acco+"' ";
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
		if(rs.next())
        {
			atm.add(new NetBanking(rs.getString(1),rs.getLong(2),rs.getInt(3)));
        }
		return atm;
   }

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
  
   public ArrayList<Service> Atmstatus(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='ATM block application' and  accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> creditstatus(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='credit block application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> debitstatus(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='debit block application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> atmapp(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='atm application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> creditapp(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='credit application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
			return service;
        }
		return service;
   }
   public ArrayList<Service> debitapp(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='debit application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> netapp(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='net banking application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> changeadd(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='change address application' and  accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> changemob(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='change mobile no application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> changetype(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='change accotype application' and accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   public ArrayList<Service> closeacc(String email) throws SQLException
   {
	   ArrayList<Service>service=new ArrayList<Service>();
	   long acco=fetchAccono(email);
	   String status="applied";
	   String query="select * from service where service_type='closing account application' and  accno='"+acco+"' and status='"+status+"' ";
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
		if(rs==null)
		{
			return service;
		}
		if(rs.next())
        {
			service.add(new Service(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
		return service;
   }
   
   public int applyATM(String email) throws Exception
   {
	   long acco=fetchAccono(email);
	   String bank_id="select bank_id from accountholder where accno='"+acco+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	   bank_id=rs.getString(1);
		}
	   String status="applied";
	   String service_type="atm application";
	   String q="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')";
	   Statement statement=con.createStatement();
	   int c=statement.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to atm successfully******************");
	   }
	   return c;
   }
   public int applyCredit(String email) throws Exception
   {
	   long acco=fetchAccono(email);
	   String bank_id="select bank_id from accountholder where accno='"+acco+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	   bank_id=rs.getString(1);
		}
	   String status="applied";
	   String service_type="credit application";
	   String q="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')";
	   Statement statement=con.createStatement();
	   int c=statement.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to atm successfully******************");
	   }
	   return c;
   }
   public int applyDebit(String email) throws Exception
   {
	   long acco=fetchAccono(email);
	   String bank_id="select bank_id from accountholder where accno='"+acco+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	         bank_id=rs.getString(1);
		}
	   String status="applied";
	   String service_type="debit application";
	   String q="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')";
	   Statement statement=con.createStatement();
	   int c=statement.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to atm successfully******************");
	   }
	   return c;
   }
   
   
   public int applyNetbanking(String email) throws Exception
   {  
	   String empty="";
	   long mobile=0;
	   long acco=fetchAccono(email);
	   String bank_id="select bank_id,mobile from accountholder where accno='"+acco+"'";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	         bank_id=rs.getString(1);
	         mobile=rs.getLong(2);
		}
	   String status="applied";
	   String service_type="net banking application";
	   
	
	   String q="insert into service (service_type,accno,status,service_description,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+mobile+"','"+bank_id+"')";
	   Statement sta=con.createStatement();
	   int c=sta.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to netbanking successfully******************");
	   }
	   
	   return c;
	 }
   
   
   public int changeAddress(String email,String address) throws Exception
   {
	   long acco=fetchAccono(email);
	   String bank="select bank_id from accountholder where accno='"+acco+"'";
	   String bank_id="";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	         bank_id=rs.getString(1);
		}
	   String status="applied";
	   String service_type="change address application";
	   String q="insert into service (service_type,accno,status,service_description,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+address+"','"+bank_id+"')";
	   Statement statement=con.createStatement();
	   int c=statement.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to address change successfully******************");
	   }

	  return c; 
   }
   
   public int changemobile(String email,long number) throws Exception
   {
	   long acco=fetchAccono(email);
	   String bank="select bank_id from accountholder where accno='"+acco+"'";
	   String bank_id="";
	   Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(bank);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.next())
		{
	         bank_id=rs.getString(1);
		}
	   String status="applied";
	   String service_type="change mobile no application";
	   String q="insert into service (service_type,accno,status,service_description,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+number+"','"+bank_id+"')";
	   Statement statement=con.createStatement();
	   int c=statement.executeUpdate(q);
	   if(c>0)
	   {
		   System.out.println("****************applied to mobile number change successfully******************");
	   }
	   
	   return c;
	   }
	   
   public int Atmblock(String email) throws SQLException
   {
	    long acco=fetchAccono(email);
	    String status="applied";
	    String service_type="ATM block application";
	    String bank="select bank_id from accountholder where accno='"+acco+"'";
		   String bank_id="";
		   Statement st = null;
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = null;
			try {
				rs = st.executeQuery(bank);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs.next())
			{
		         bank_id=rs.getString(1);
			}
        String service="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')"; 
		Statement s=con.createStatement();
	    int count=s.executeUpdate(service);
	    if(count!=0)
	    {
		     System.out.println("applied for the blocking service done successfully");
	    }
	    return count;
   
   }																												
				
	   public int creditblock(String email) throws SQLException
	   {
		   long acco=fetchAccono(email);
	      String status="applied";
	       String bank="select bank_id from accountholder where accno='"+acco+"'";
		   String bank_id="";
		   Statement st = null;
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = null;
			try {
				rs = st.executeQuery(bank);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs.next())
			{
		         bank_id=rs.getString(1);
			}
	    String service_type="credit block application";
		
				String service="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')"; 
				Statement s=con.createStatement();
				int count=s.executeUpdate(service);
				if(count!=0)
				{
					System.out.println("applied for the blocking service done successfully");
				}
				
			return count;	
		}
				
   
         public int debitblock(String email) throws SQLException
		{
           long acco=fetchAccono(email);
   	       String status="applied";
   	       String bank="select bank_id from accountholder where accno='"+acco+"'";
   		   String bank_id="";
   		   Statement st = null;
   			try {
   				st = con.createStatement();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			ResultSet rs = null;
   			try {
   				rs = st.executeQuery(bank);
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   			if(rs.next())
   			{
   		         bank_id=rs.getString(1);
   			}
			String service_type="debit block application";
			
				String service="insert into service (service_type,accno,status,bank_id) values('"+service_type+"','"+acco+"','"+status+"','"+bank_id+"')"; 
				Statement s=con.createStatement();
				int count=s.executeUpdate(service);
				if(count!=0)
				{
					System.out.println("applied for the blocking service done successfully");
				}
			return count;
		}  
   
   public int atmpin(String mail,int newpassword) throws SQLException
          { 
	             long acco=fetchAccono(mail);
     			 String update="update atmcard set atm_pin= '"+newpassword+"' where accno='"+acco+"'";
     			 Statement rsatm1=con.createStatement();
     			 int count=rsatm1.executeUpdate(update);
     			 if(count!=0)
     			 {
     				 System.out.print("ATM pin has been changed successfully");
     			 }
		   return count;
     		
     	 }
   public int debitpin(String mail,int newpassword) throws SQLException
   { 
          long acco=fetchAccono(mail);
			 String update="update debitcard set debit_card_pin='"+newpassword+"' where accno='"+acco+"'";
			 Statement rsatm1=con.createStatement();
			 int count=rsatm1.executeUpdate(update);
			 if(count!=0)
			 {
				 System.out.print("ATM pin has been changed successfully");
			 }
			return count;
		
	 }
   public int creditpin(String mail,int newpassword) throws SQLException
   { 
          long acco=fetchAccono(mail);
			 String update="update creditcard set credit_pin='"+newpassword+"' where accno='"+acco+"'";
			 Statement rsatm1=con.createStatement();
			 int count=rsatm1.executeUpdate(update);
			 if(count!=0)
			 {
				 System.out.print("ATM pin has been changed successfully");
			 }
			return count;
		
	 }
   
   public int checkBanlance(String mail, int pin)throws Exception
   {
	   
	   long acco=fetchAccono(mail);
	   int balance=0;
	   String pinquery="select upi_pin,accno from netbanking where upi_pin='"+pin+"' and accno='"+acco+"' ";
	   Statement state=con.createStatement();
	   ResultSet pinno=state.executeQuery(pinquery);
	   if(pinno.next())
	   {
	   String q="select balance from accountholder where accno='"+acco+"'";
	   Statement statement=con.createStatement();
	   ResultSet r=statement.executeQuery(q);
	   if(r.next())
	   {
	   		balance=r.getInt(1);  		   
	    }
	   }
	   return balance;
	   
   }
   
   public int BankTranfer(String mail,int amount,String ifsc,String bank,long account) throws SQLException
   {
	       long acco=fetchAccono(mail);
	       int bal=0;
		   String type="upi id";
		   String q="select balance from accountholder where accno='"+acco+"'";
		   Statement statement=con.createStatement();
		   ResultSet r=statement.executeQuery(q);
		   while(r.next())
		   {
			    bal=r.getInt(1);
		   }
			   int currbal=bal-amount;
			   int co=0;
			   String ins="insert into transaction(transaction_amount,transaction_accno,transaction_bank,transaction_type,accno,transaction_date,transaction_time)values('"+amount+"','"+account+"','"+bank+"','"+type+"','"+acco+"',curdate(),curtime())";
			   Statement s=con.createStatement();
			   int v=s.executeUpdate(ins);
			   if(v!=0)
			   {
				   
				   String up="update accountholder set balance='"+currbal+"' where accno='"+acco+"'";
				   Statement se=con.createStatement();
				   co=se.executeUpdate(up);
				   if(co!=0)
				   {
					   System.out.println("Transaction successfully done");
					   System.out.println("press 1 to check balance");
					 
					   
				   }
			   }
			   return co;
   }
   
   
   
   
   public void apply(int service_id,long accno) throws Exception
   {
 		 String status="accepted";
 		 String apply="update service set status='"+status+"' where accno='"+accno+"' and service_id='"+service_id+"'";
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
 	   public void atmupdate(long accno) throws Exception
 	   {
 		  String status="activated";
 	  int min = 1000;  
 	  int max = 9000;  
 	  int b = (int)(Math.random()*(max-min+1)+min);  
 	  System.out.println(b);
 	  String updateatm="insert into atmcard(accno,atm_pin,status) values('"+accno+"','"+b+"','"+status+"')";
 	  Statement st2=con.createStatement();
 	  int count2=st2.executeUpdate(updateatm);
 	  if(count2>0)
 	  {
 		 System.out.println("updated into atm details");  
 	  }
 	  int atm_id=0;
 	  String select ="select atm_id from atmcard";
 	  Statement st3=con.createStatement();
 	  ResultSet rs3=st3.executeQuery(select);
 	  if(rs3.next())
 	  {
 		  atm_id=rs3.getInt(1);
 	  }
 	  String update="update accountholder set atmcard='"+atm_id+"' where accno='"+accno+"'";
 	  Statement st1=con.createStatement();
 	  int count=st1.executeUpdate(update);
 	  if(count>0)
 	  {
 		  System.out.println("updated into account details");
 	  }

 }
 	   public void creditupdate(long accno) throws Exception
 	   {
 		      String status="activated";
 		 	  int min = 1000;  
 		 	  int max = 9000;  
 		 	  int b = (int)(Math.random()*(max-min+1)+min);  
 		 	  System.out.println(b);
 		 	  String updateatm="insert into creditcard(accno,credit_pin,status) values('"+accno+"','"+b+"','"+status+"')";
 		 	  Statement st2=con.createStatement();
 		 	  int count2=st2.executeUpdate(updateatm);
 		 	  if(count2>0)
 		 	  {
 		 		 System.out.println("updated into credit details");  
 		 	  }
 		 	  int credit_id=0;
 		 	  String select ="select credit_card_id from creditcard";
 		 	  Statement st3=con.createStatement();
 		 	  ResultSet rs3=st3.executeQuery(select);
 		 	  if(rs3.next())
 		 	  {
 		 		  credit_id=rs3.getInt(1);
 		 	  }
 		 	  String update="update accountholder set creditcard='"+credit_id+"' where accno='"+accno+"'";
 		 	  Statement st1=con.createStatement();
 		 	  int count=st1.executeUpdate(update);
 		 	  if(count>0)
 		 	  {
 		 		  System.out.println("updated into account details");
 		 	  } 
 	   }
   
 	   public void debitupdate(long accno)throws Exception
 	   {
 		      String status="activated";
 		 	  int min = 1000;  
 		 	  int max = 9000;  
 		 	  int b = (int)(Math.random()*(max-min+1)+min);  
 		 	  System.out.println(b);
 		 	  String updateatm="insert into debitcard(accno,debit_card_pin,status) values('"+accno+"','"+b+"','"+status+"')";
 		 	  Statement st2=con.createStatement();
 		 	  int count2=st2.executeUpdate(updateatm);
 		 	  if(count2>0)
 		 	  {
 		 		 System.out.println("updated into debit details");  
 		 	  }
 		 	  int debit_id=0;
 		 	  String select ="select debit_id from debitcard";
 		 	  Statement st3=con.createStatement();
 		 	  ResultSet rs3=st3.executeQuery(select);
 		 	  if(rs3.next())
 		 	  {
 		 		  debit_id=rs3.getInt(1);
 		 	  }
 		 	  String update="update accountholder set debitcard='"+debit_id+"' where accno='"+accno+"'";
 		 	  Statement st1=con.createStatement();
 		 	  int count=st1.executeUpdate(update);
 		 	  if(count>0)
 		 	  {
 		 		  System.out.println("updated into account details");
 		 	  } 
 	   }
 	   
 	  public void changeAddressservice(long accno,String description,int service_id) throws Exception
	   {
		 	  String update="update accountholder set address='"+description+"' where accno='"+accno+"'";
		 	  Statement st1=con.createStatement();
		 	  int count=st1.executeUpdate(update);
		 	  if(count>0)
		 	  {
		 		  System.out.println("updated into account details");
		 	  }
		   
	   }
 	  
 	 public void Netbankingservice(long accno,String description,int service_id) throws Exception
	   {  
		 	  String ybl=description+"@ybl";
		 	  int min = 1000;  
		 	  int max = 9000;  
		 	  int b = (int)(Math.random()*(max-min+1)+min);  
		 	  System.out.println(b);
		 	  String updateatm="insert into netbanking(upi_id,accno,upi_pin) values('"+ybl+"','"+accno+"','"+b+"')";
		 	  Statement st2=con.createStatement();
		 	  int count2=st2.executeUpdate(updateatm);
		 	  if(count2>0)
		 	  {
		 		 System.out.println("updated into netbanking details");  
		 	  }
		 	 String update="update accountholder set netbanking='"+ybl+"' where accno='"+accno+"'";
		 	  Statement st1=con.createStatement();
		 	  int count=st1.executeUpdate(update);
		 	  if(count>0)
		 	  {
		 		  System.out.println("updated into account details");
		 	  }
		   
	   }
 	 
 	 public void blockservice(long accno,String type) throws SQLException
 	 {
 		if(type.equals("ATM block application"))
		  {	  
		  String atmcard="select atmcard from accountholder where accno='"+accno+"'";
		  Statement s=con.createStatement();
		  ResultSet rs=s.executeQuery(atmcard);
		  if(rs.next())
		  {
			 int atmid=rs.getInt(1);
			 System.out.print(atmid+" "+accno);
			 String update="update atmcard set status='deactivated' where accno='"+accno+"'";
			 s=con.createStatement();
			 int count=s.executeUpdate(update);
			 if(count!=0)
			 {
				String update1="update accountholder set atmcard= null where accno='"+accno+"'" ;
				s=con.createStatement();
				int c=s.executeUpdate(update1);
				if(c!=0)
				{
					System.out.println("atm card has been blocked");
					String service="update service set status ='accepted' where accno='"+accno+"'";
					s=con.createStatement();
					int serv=s.executeUpdate(service);
					if(serv!=0)
					{
						System.out.println("application done");
					}
				}
				else 
				{
					System.out.println("not blocked");
				}
			 }
			 
			 
		  }
		  else 
		  {
			  System.out.println("some error occured");
		  }
		  }
 	//////////////////////////////////////////////////////////////////	
 		else if(type.equals("credit block application"))
		  {
			  
			  String creditcard="select creditcard from accountholder where accno='"+accno+"'";
			  Statement s=con.createStatement();
			  ResultSet rs=s.executeQuery(creditcard);
			  if(rs.next())
			  {
				int creditid=rs.getInt(1);
				System.out.println(creditid);
				String update="update creditcard set status='deactivated' where accno='"+accno+"'";
			    s=con.createStatement();
				int count=s.executeUpdate(update);
				if(count!=0)
				{
					String update1="update accountholder set creditcard = null  where accno='"+accno+"'" ;
					s=con.createStatement();
					int c=s.executeUpdate(update1);
					if(c!=0)
					{
						System.out.println("credit card has been blocked");
						String service="update service set status ='accepted' where accno='"+accno+"'";
						s=con.createStatement();
						int serv=s.executeUpdate(service);
						if(serv!=0)
						{
							System.out.println("application done");
						}
					}
				}
			  }
			  }
 		///////////////////////////////////////////////////////////////////////
 		else if(type.equals("debit block application"))
		  {
			 
			  String debitcard="select debitcard from accountholder where accno='"+accno+"'";
			  Statement s=con.createStatement();
			  ResultSet rs=s.executeQuery(debitcard);
			  if(rs.next())
			  {
				  int debitid=rs.getInt(1);
				  String update="update debitcard set status='deactivated' where accno='"+accno+"' and debit_id ='"+debitid+"'";
				  s=con.createStatement();
				  int count=s.executeUpdate(update);
				  if(count!=0)
				  {
					  String update1="update accountholder set debitcard= null where accno='"+accno+"'" ;
						s=con.createStatement();
						int c=s.executeUpdate(update1);
						if(c!=0)
						{
							System.out.println("debitcard has been blocked");
							String service="update service set status ='accepted' where accno='"+accno+"'";
							s=con.createStatement();
							int serv=s.executeUpdate(service);
							if(serv!=0)
							{
								System.out.println("application done");
							}
						}
					  
				  }
			  }
			  
			
			  
			  
		  }
 
		  
	  }
 	 


   	
}
