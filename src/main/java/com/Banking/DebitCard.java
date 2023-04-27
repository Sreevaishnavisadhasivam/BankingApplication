package com.Banking;

public class DebitCard
{
  private int debit_id;
  private long accno;
  private int debit_card_pin;
  private String status;
  public DebitCard()
  {
	  
  }
  public DebitCard(int debit_id,long accno,int debit_card_pin,String status )
  {
	 this.debit_id=debit_id;
	 this.accno=accno;
	 this.debit_card_pin=debit_card_pin;
	 this.status=status;
  }
  
  public void setdebit_id(int debit_id)
  {
	  this.debit_id=debit_id;
  }
  public void setaccno(long accno)
  {
	  this.accno=accno;
  }
  public void setdebit_card_pin(int debit_card_pin)
  {
	  this.debit_card_pin=debit_card_pin; 
  }
  public void setstatus(String status)
  {
	  this.status=status;
  }
  public int getdebit_id()
  {
	  return debit_id;
  }
  public long getaccno()
  {
	  return accno;
  }
  public int getdebit_card_pin()
  {
	  return debit_card_pin; 
  }
  public String getstatus()
  {
	  return status;
  }
}
