package com.Banking;
public class HolderCredentials
{
  public String username;
  public String password;
  public long mobileno;
  public String email_id;
  public long accno;
  public void setUsername(String username)
  {
	  this.username=username;
  }
  public void setPassword(String password)
  {
	  this.password=password;
  }
  public void setMobileno(long mobileno)
  {
	  this.mobileno=mobileno;
  }
  public void setAccno(long accno)
  {
	  this.accno=accno;
  }
  
  public String getUsername()
  {
	  return username;
  }
  public String getPassword()
  {
	  return password;
  }
  public long getMobileno()
  {
	  return mobileno;
  }
  public long getAccno()
  {
	  return accno;
  }
}
