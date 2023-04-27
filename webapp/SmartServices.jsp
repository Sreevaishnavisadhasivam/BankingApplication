<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page import="com.Banking.SmartTransaction,com.Banking.AtmCard,com.Banking.CreditCard,com.Banking.DebitCard,com.Banking.NetBanking,com.Banking.Service"%>
    <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
    <%@page import="java.util.Iterator"%> 
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@page import ="com.Banking.Main" %>
    <link href="Home.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0"); %>
<% Main m=new Main();
   Main.getConnection();%>
<%
	if(session.getAttribute("Email")==null){
		response.sendRedirect("HomePage.jsp");
	}
%>

<div class="topnav">
  <a href="UserHome.jsp">HOME</a>
</div>
<div class="container">
<div class="row">
<form id="applyatm" method="post" action="ApplyAtm"></form>
<form id="blockatm" method="post" action="BlockAtm"></form>

<div class="col-sm-3">
<p>ATM SERVICES</p>
<% 
if(session.getAttribute("atmpin")!=null)
{
	%><p> YOUR PIN HAS BEEN CHANGE SUCCESSFULLY</p><% 
	session.setAttribute("atmpin", null);
}
%>
<% SmartTransaction acco=new SmartTransaction();%>
<% String email=(String)session.getAttribute("Email"); %>
<% ArrayList<AtmCard> accodet = acco.atmService(email);%>
<%ArrayList<Service>service=acco.Atmstatus(email); %>
<%ArrayList<Service>atmapp=acco.atmapp(email); %>
<%if(accodet.size()!=0)
	{%>
	<%if(service.size()==0) {%>
	<button form="blockatm" type="submit" class="btn btn-primary">BLOCK SERVICE</button><h1></h1>
	<button  class="btn btn-primary"><a href="AtmChangePin.jsp">CHANGE PIN</a></button><h1></h1>
	<%}
	else  
	{
	%>
	<p>your application for blocking service is  on progress wait for some days</p>
	<%}}
	else if(atmapp.size()==0)
	{
	%>
	<button form="applyatm" type="submit" class="btn btn-primary">APPLY</button><%
	}
	else 
	{
		%><p>your application for service is on progress wait for some days</p><% 
	}%>
</div>


<form id="applycredit" method="get" action="ApplyCredit"></form>
<form id="blockcredit" method="post" action="BlockCredit"></form>

<div class="col-sm-3">
<p>CREDIT SERVICES</p>
<%if(session.getAttribute("creditpin")!=null)
{
	%><p> YOUR PIN HAS BEEN CHANGE SUCCESSFULLY</p><% 
	session.setAttribute("atmpin", null);
}%>
<% SmartTransaction accoo=new SmartTransaction();%>
<% String mail=(String)session.getAttribute("Email"); %>
<% ArrayList<CreditCard> accodet1 = accoo.creditService(mail);%>
<%ArrayList<Service>creditservice=acco.creditstatus(mail); %>
<%ArrayList<Service>creditapp=acco.creditapp(email); %>
<%if(accodet1.size()!=0)
	{%>
	<%if(creditservice.size()==0) {%>
	<button form="blockcredit" type="submit" class="btn btn-primary">BLOCK SERVICE</button><h1></h1>
	<button class="btn btn-primary"><a href="CreditChangePin.jsp">CHANGE PIN</a></button><h1></h1>
	<%}
	else  
	{
	%>
	    <p>your application for blocking service is not yet complete please wait for some days</p>
	<%}}
	else if(creditapp.size()==0)
	{
	%>
	     <button form="applycredit" type="submit" class="btn btn-primary">APPLY</button><%
	}
	else 
	{
		%><p>your application for service is on progress wait for some days</p><% 
	}%>
</div>



<form id="applydebit" method="post" action="ApplyDebit"></form>
<form id="blockdebit" method="post" action="BlockDebit"></form>

<form id=""></form>
<div class="col-sm-3">
<p>DEBIT SERVICES</p>
<%if(session.getAttribute("debitpin")!=null)
{
	%><p> YOUR PIN HAS BEEN CHANGE SUCCESSFULLY</p><% 
	session.setAttribute("debitpin", null);
}%>
<% SmartTransaction debit=new SmartTransaction();%>
<% String gmail=(String)session.getAttribute("Email"); %>
<% ArrayList<DebitCard> Debit = debit.debitService(gmail);%>
<%ArrayList<Service>debitservice=acco.debitstatus(mail); %>
<%ArrayList<Service>debitapp=acco.debitapp(email); %>
<%if(Debit.size()!=0)
	{%>
	<%if(debitservice.size()==0) {%>
	<button form="blockdebit" type="submit" class="btn btn-primary">BLOCK SERVICE</button><h1></h1>
	<button class="btn btn-primary"><a href="DebitChangePin.jsp">CHANGE PIN</a></button><h1></h1>
	<%}
	else  
	{
	%>
	<p>your application for blocking service is not yet complete please wait for some days</p>
	<%}}
	else if(debitapp.size()==0)
	{
	%>
	<button form="applydebit" type="submit" class="btn btn-primary">APPLY</button><%
	}
	else 
	{
		%><p>application for service is on progress wait for some days</p><% 
	}%>
</div>

<form id="applynetbanking" method="get" action="ApplyNetbanking"></form>
<div class="col-sm-3">

<p>NET BANKING</p>
<% SmartTransaction netbank=new SmartTransaction();%>
<% String Gmail=(String)session.getAttribute("Email"); %>
<% ArrayList<NetBanking> NetBank = netbank.netbankingService(Gmail);%>
<%ArrayList<Service>netapp=acco.netapp(email); %>
<%if(NetBank.size()!=0)
    {%>
	<button type="button" class="btn btn-primary">CHANGE PIN</button><h1></h1>
	<%}
	else 
	{
		  if(netapp.size()!=0)
	       {
	    	   %><p>your application for service is on progress wait for some days</p><%
	       }
	       else {%>
		   <button form="applynetbanking" type="submit" class="btn btn-primary">APPLY</button><%
	}}%>
	
</div>
</div>
</div>
<hr>
<div class="container">
<div class="row">


<form id="changeaddress" method="post" action="ChangeAddress"></form>
<div class="col-sm-3">
<% SmartTransaction smart=new SmartTransaction();%>
<% Gmail=(String)session.getAttribute("Email"); %>
<% ArrayList<Service> changeadd=smart.changeadd(Gmail);%>
<p>CHANGE ADDRESS FORM</p>
<div class="form-group">
<%if(changeadd.size()==0)
{%>
  <input type="text" class="form-control" name="address" placeholder="ENTER YOUR NEW ADDRESS">
</div>
<button form="changeaddress" type="submit" class="btn btn-primary">SUBMIT</button>
<%}else {%>
               <p>your application is not completed wait form sometime</p>
	<%}%>
</div>


</div>
</div>
</body>
</html>