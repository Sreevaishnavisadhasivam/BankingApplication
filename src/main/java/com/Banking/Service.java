package com.Banking;

public class Service 
{
	public int service_id;
	public String service_type;
	public String description;
	public String status;
	public long accno;
	public String bank_id;
   Service()
   {
	   
   }
   Service(int service_id,String service_type,String description,String status,long accno,String bank_id)
   {
	   this.service_id=service_id;
	   this.service_type=service_type;
	   this.description=description;
	   this.status=status;
	   this.accno=accno;
	   this.bank_id=bank_id;
   }
   public void setService_id(int service_id)
   {
	   this.service_id=service_id;
   }
   public void setService_type(String service_type)
   {
	   this.service_type=service_type;
   }
   public void setDescription(String description)
   {
	   this.description=description;  
   }
   public void setStatus(String status)
   {
	   this.status=status;
   }
   public void setAccno(long accno)
   {
	   this.accno=accno;
   }
   public void setBank_id(String bank_id)
   {
	   this.bank_id=bank_id; 
   }
   
   public int getService_id()
   {
	  return  service_id;
   }
   public String getService_type()
   {
	   return service_type;
   }
   public String getDescription()
   {
	   return description;  
   }
   public String getStatus()
   {
	   return status;
   }
   public long getAccno()
   {
	   return accno;
   }
   public String getBank_id()
   {
	   return bank_id; 
   }
}
