package com.Banking;

public class CorperateUserdet 
{
  public String   branch_admin_id;
  public String   admin_name;
  public String   permission; 
  public String   branch;
  public String   branch_bank_id;
  public long     mobilno;
  public String   email;
  
  public CorperateUserdet()
  {
	  
  }
  public CorperateUserdet(String branch_admin_id,String admin_name,String permission,String branch,String branch_bank_id,long mobiln,String email)
  {
	  this.branch_admin_id=branch_admin_id;
	  this.admin_name=admin_name;
	  this.permission=permission; 
	  this.branch=branch;
	  this.branch_bank_id=branch_bank_id;
	  this.mobilno=mobilno;
	  this.email=email;
  }
  
  public void setBranch_admin_id(String branch_admin_id)
  {
	  this.branch_admin_id=branch_admin_id;
  }
  public void setadmin_name(String admin_name)
  {
	  this.admin_name=admin_name;
  }
  public void setPermission(String permission)
  {
	  this.permission=permission;
  }
  public void setBranch(String branch)
  {
	  this.branch=branch;
  }
  public void setBranch_bank_id(String branch_bank_id)
  {
	  this.branch_bank_id=branch_bank_id;
  }
  public void setmobilno(long mobilno)
  {
	  this.mobilno=mobilno;
  }
  public void setEmail(String  email)
  {
	  this.email=email;
  }
  
  public String getBranch_admin_id()
  {
	  return branch_admin_id;
  }
  public String getadmin_name()
  {
	  return admin_name;
  }
  public String getPermission()
  {
	  return permission;
  }
  public String getBranch()
  {
	  return branch;
  }
  public String getBranch_bank_id()
  {
	  return branch_bank_id;
  }
  public long getmobilno()
  {
	  return mobilno;
  }
  public String getEmail()
  {
	  return email;
  }
}
