package com.Banking;

public class AtmCard 
{
  private int atm_id;
  private long accono;
  private int atmpin;
private String status;
public AtmCard()
  {
	  
  }
  public AtmCard(int atm_id,long accono,int atmpin,String status)
  {
	 this.atm_id=atm_id;
	 this.accono=accono;
	 this.atmpin=atmpin;
	 this.status=status;
  }
  
  public void setatm_id(int atm_id)
  {
	  this.atm_id=atm_id;
  }
  public void setaccono(long accono)
  {
	  this.accono=accono;
  }
  public void setatmpin(int atmpin)
  {
	  this.atmpin=atmpin; 
  }
  public void setstatus(String status)
  {
	  this.status=status;
  }
  public int getatm_id()
  {
	  return atm_id;
  }
  public long getaccono()
  {
	  return accono;
  }
  public int getatmpin()
  {
	  return atmpin; 
  }
  public String getstatus()
  {
	  return status;
  }
}
