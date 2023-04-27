package com.Banking;

public class Transaction 
{
private int transaction_id;
private int transaction_amount;
private long transaction_accono;
private String transaction_bank;
private String Transaction_Branch;
private String Transaction_type;
private long accno;
private String IFSC_code;
private String transaction_time;
private String transaction_date;

public Transaction()
  {
	  
  }
  
  public Transaction(int transaction_id,int transaction_amount,long transaction_accono,String transaction_bank,String transaction_date ,String transaction_time)
  {
	this.transaction_id=transaction_id;
	this.transaction_amount=transaction_amount;
	this.transaction_accono=transaction_accono;
	this.transaction_bank=transaction_bank;
	this.Transaction_Branch=Transaction_Branch;
	this. accno= accno;
	this.Transaction_type=Transaction_type;
	this.IFSC_code=IFSC_code;
	this.transaction_date=transaction_date;
	this.transaction_time=transaction_time;
  }
  
  public void settransaction_id(int transaction_id)
  {
	  this.transaction_id=transaction_id;  
  }
  public void settransaction_amount(int transaction_amount)
  {
	  this.transaction_amount=transaction_amount;
  }
  public void settransaction_accono(long transaction_accono)
  {
	  this.transaction_accono=transaction_accono;
  }
  public void settransaction_bank(String transaction_bank)
  {
	  this.transaction_bank=transaction_bank;
  }
  public void setTransaction_Branch(String Transaction_Branch)
  {
	  this.Transaction_Branch=Transaction_Branch;
  }
  public void setaccno(long accno)
  {
	  this. accno= accno;
  }
  public void setTransaction_type(String Transaction_type)
  {
	  this.Transaction_type=Transaction_type;
  }
  public void setIFSC_code(String IFSC_code)
  {
	  this.IFSC_code=IFSC_code;
  }
  public void settransaction_date(String transaction_date)
  {
	  this.transaction_date=transaction_date;  
  }
  public void settransaction_time(String transaction_time)
  {
	  this.transaction_time=transaction_time;
  }
  
  public int gettransaction_id()
  {
	  return transaction_id;  
  }
  public int gettransaction_amount()
  {
	  return transaction_amount;
  }
  public long gettransaction_accono()
  {
	  return transaction_accono;
  }
  public String gettransaction_bank()
  {
	  return transaction_bank;
  }
  public String getTransaction_Branch()
  {
	  return Transaction_Branch;
  }
  public long getaccno()
  {
	  return accno;
  }
  public String getransaction_type()
  {
	  return Transaction_type;
  }
  public String getIFSC_code(String IFSC_code)
  {
	  return IFSC_code;
  }
  public String gettransaction_date()
  {
	  return transaction_date;  
  }
  public String gettransaction_time()
  {
	  return transaction_time;
  }
}
