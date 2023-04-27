<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="com.Banking.Bank,com.Banking.Admin"%>
    <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
    <%@page import="java.util.Iterator"%> 
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@page import ="com.Banking.Main" %>
    <link rel="stylesheet" href="Home.css">
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
	if(session.getAttribute("adminid")==null){
		response.sendRedirect("HomePage.jsp");
	}

%>
  <div class="topnav">
  <a href="AdminHome.jsp">HOME</a>
</div>
<div class="centertable">
<table>
<% Admin acco=new Admin();%>
<% ArrayList<Bank> accodet = acco.viewBank();%>
<% Iterator<Bank> iterator = accodet.iterator();  %>
	<tr>
	<th>Bank ID</th>
	<th>Bank Name</th>
	<th>Branch</th>
	<th>IFSC_code</th>
	<th>pincode</th>
	<th>Bank head id</th>
	</tr>
	<%while(iterator.hasNext())
	{
		Bank it = iterator.next(); //assign individual employee record to the employee class object
	
	 %>
	 <tr>
	     <td><% out.print(it.getbank_id());%></td>
	     <td><% out.print(it.getbank_name());%></td>
	     <td><% out.print(it.getbranch());%></td>
	     <td><% out.print(it.getIFSC_code());%></td>
	     <td><% out.print(it.getpincode());%></td>
	     <td><% out.print(it.getbank_head_id());%></td></tr>
<%  
	}
	if(accodet.size()==0)
	{
		 %><h1>NO DATA AVALAILABLE</h1><% 
	}
%>
</table>
    </div>
</body>
</html>