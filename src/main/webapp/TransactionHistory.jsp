<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TRANSACTION HISTORY</title>
<%@ page import="com.Banking.AccountHolder,com.Banking.Transaction"%>
    <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
    <%@page import="java.util.Iterator"%> 
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <link rel="stylesheet" href="Home.css">
    <%@page import ="com.Banking.Main" %>
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

<div class="centertable">
<table>
<%
	if(session.getAttribute("Balance")!=null){
		%><p> your current balance in your account is</p><%out.print((int)session.getAttribute("Balance"));
		session.setAttribute("Balance", null);
	}
	
%>
<%
	if(session.getAttribute("invalid")!=null){
		%><p>you have entered an invalid pin</p><%
		session.setAttribute("invalid", null);
	}
	
%>
<% AccountHolder acco=new AccountHolder();%>
<%String email=(String)session.getAttribute("Email"); %>
<% ArrayList<Transaction> accodet = acco.viewTransactionHistory(email);%>
<%if(accodet.size()==0) 
{%>
<p>NO TRANSACTIONS DONE SO FAR</p>
<% }%>
<% Iterator<Transaction> iterator = accodet.iterator();  %>
	<tr>
	<th>TRANSACTION ID</th>
	<th>AMOUNT</th>
	<th>TRANSACTION ACCO</th>
	<th>TRANSACTION BANK</th>
	<th>DATA</th>
	<th>TIME</th>
	</tr>
	<%while(iterator.hasNext())
	{
		Transaction it = iterator.next(); //assign individual employee record to the employee class object
	
	 %>
	 <tr>
	     <td><% out.print(it.gettransaction_id());%></td>
	     <td><% out.print(it.gettransaction_amount());%></td>
	     <td><% out.print(it.gettransaction_accono());%></td>
	     <td><% out.print(it.gettransaction_bank());%></td>
	     <td><% out.print(it.gettransaction_date());%></td>
	     <td><% out.print(it.gettransaction_time());%></td></tr>
<%  
	}
%>
</table>
</div>
</body>
</html>