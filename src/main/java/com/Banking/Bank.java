package com.Banking;

public class Bank 
{
public String bank_id;
public String bank_name;
public String branch;
public String IFSC_code;
public int pincode;
public String bank_head_id;
Bank()
  {
	  
  }
  Bank(String bank_id,String bank_name,String branch,String IFSC_code,int pincode,String bank_head_id)
  {
	  this.bank_id=bank_id;
	  this.bank_name=bank_name;
	  this.branch=branch;
	  this.IFSC_code=IFSC_code;
	  this.pincode=pincode;
	  this.bank_head_id=bank_head_id;
  }
  
  public void setBank_id(String bank_id)
  {
	  this.bank_id=bank_id; 
  }
   
  public void setbank_name(String bank_name)
  {
	  this.bank_name=bank_name;
  }
  public void setbranch(String branch)
  {
	  this.branch=branch;
  }
  public void setIFSC_code(String IFSC_code)
  {
	  this.IFSC_code=IFSC_code;
  }
  public void setpincode(int pincode)
  {
	  this.pincode=pincode;
  }
  public void setbank_head_id(String bank_head_id)
  {
	  this.bank_head_id=bank_head_id;
  }
  
  public String getbank_id()
  {
	  return bank_id;
  }
  public String getbank_name()
  {
	  return bank_name;
  }
  public String getbranch()
  {
	  return branch;
  }
  public String getIFSC_code()
  {
	  return IFSC_code;
  }
  public int getpincode()
  {
	  return pincode;
  }
  public String getbank_head_id()
  {
	  return bank_head_id;
  }
}
