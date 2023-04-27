
package com.Banking;

public class CreditCard
{
  private int credit_card_id;
  private long accno;
  private int credit_pin;
  private String status;
  public CreditCard()
  {
	  
  }
  public CreditCard(int credit_card_id,long accno,int credit_pin,String status )
  {
	 this.credit_card_id=credit_card_id;
	 this.accno=accno;
	 this.credit_pin=credit_pin;
	 this.status=status;
  }
  
  public void setcredit_card_id(int credit_card_id)
  {
	  this.credit_card_id=credit_card_id;
  }
  public void setaccno(long accno)
  {
	  this.accno=accno;
  }
  public void setcredit_pin(int credit_pin)
  {
	  this.credit_pin=credit_pin; 
  }
  public void setstatus(String status)
  {
	  this.status=status;
  }
  public int getcredit_card_id()
  {
	  return credit_card_id;
  }
  public long getaccno()
  {
	  return accno;
  }
  public int getcredit_pin()
  {
	  return credit_pin; 
  }
  public String getstatus()
  {
	  return status;
  }
}
