package com.Banking;
public class Accountholderdetails 
{
   public String holdername;
   public long accno;
   public String address;
   public int balance;
   public String branch;
   public String Acctype;
   public int debitcard;
   public int creditcard;
   public int Atmcard;
   public long mobile;
   public String netbanking;
   public String bank_id;
   public String emailid;
   
   public Accountholderdetails()
   {
   }
   public Accountholderdetails(String holdername,long accno,String address,int balance,String branch,String Acctype,int debitcard,int creditcard,int Atmcard,long mobile,String netbanking,String bank_id,String emailid)
   {
	   this.holdername=holdername;
	   this.accno=accno;
	   this.address=address;
	   this. balance=balance;
	   this. branch=branch;
	   this. Acctype=Acctype;
	   this.debitcard=debitcard;
	   this.creditcard=creditcard;
	   this. Atmcard=Atmcard;
	   this. mobile=mobile;
	   this. netbanking=netbanking;
	   this. bank_id=bank_id;
	   this. emailid=emailid;
   }
   public void setHolderName(String holdername)
   {
	 this.holdername=holdername;  
   }
   public void setAccno(long accno)
   {
	 this.accno=accno;  
   }
   public void setAddress(String address)
   {
	 this.address=address;  
   }
   public void setBalance(int balance)
   {
	 this.balance=balance;  
   }
   public void setBranch(String branch)
   {
	 this.branch=branch;  
   }
   public void setAcctype(String Acctype)
   {
	 this.Acctype=Acctype;  
   }
   public void setDeitcard(int debitcard)
   {
	 this.debitcard=debitcard;  
   }
   public void setCreditcard(int creditcard)
   {
	 this.creditcard=creditcard;  
   }
   public void setAtmcard(int Atmcard)
   {
	 this.Atmcard=Atmcard;  
   }
   public void setMobile(long mobile)
   {
	 this.mobile=mobile;  
   }
   public void setNetbanking(String netbanking)
   {
	 this.netbanking=netbanking;  
   }
   public void setBank_id(String bank_id)
   {
	 this.bank_id=bank_id;  
   }
   public void setEmailid(String emailid)
   {
	 this.emailid=emailid;  
   }
   
   
   public String getHolderName()
   {
	  return holdername;  
   }
   public long getAccno()
   {
	 return accno;  
   }
   public String getAddress()
   {
	 return address;  
   }
   public int getBalance()
   {
	 return balance;  
   }
   public String getBranch()
   {
	 return branch;  
   }
   public String getAcctype()
   {
	 return Acctype;  
   }
   public int getDeitcard()
   {
	 return debitcard;  
   }
   public int getCreditcard()
   {
	 return creditcard;  
   }
   public int getAtmcard()
   {
	 return Atmcard;  
   }
   public long getMobile()
   {
	 return mobile;  
   }
   public String getNetbanking()
   {
	  return netbanking;  
   }
   public String getBank_id()
   {
	 return bank_id;  
   }
   public String getEmailid()
   {
	 return emailid;  
   }

}
