package com.Banking;

public class NetBanking 
{
	  private String upi_id;
	  private long accno;
	  private int upi_pin;
   public NetBanking()
   {
	   
   }
   public NetBanking(String upi_id,long accno,int upi_pin)
   {
	      this.upi_id=upi_id;
		  this.accno=accno;
		  this.upi_pin=upi_pin;
   }
   
   public void setupi_id(String upi_id)
   {
	   this.upi_id=upi_id; 
   }
   public void setaccno(long accno)
   {
	   this.accno=accno;
   }
   public void setupi_pin(int upi_pin)
   {
	   this.upi_pin=upi_pin;
   }
   public String getupi_id()
   {
	   return upi_id; 
   }
   public long getaccno()
   {
	   return accno;
   }
   public int getupi_pin()
   {
	   return upi_pin;
   }
}
