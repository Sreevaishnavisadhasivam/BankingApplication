package com.Banking;

public class CorporateUserCredentials 
{
   public String adminname;
   public String password;
   public String adminid;
   public String email;
   public void setAdminname(String adminname)
   {
 	  this.adminname=adminname;
   }
   public void setPassword(String password)
   {
 	  this.password=password;
   }
   public void setAdminid(String adminid)
   {
 	  this.adminid=adminid;
   }
   public void setEmail( String email)
   {
 	  this.email= email;
   }
   
   public String getAdminname()
   {
 	  return adminname;
   }
   public String getPassword()
   {
 	  return password;
   }
   public String getAdminid()
   {
 	  return adminid;
   }
   public String getEmail()
   {
 	  return email;
   }
}
