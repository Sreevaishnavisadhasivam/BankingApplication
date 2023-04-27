<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@page import ="com.Banking.Main" %>
    <link href="style.css" rel="stylesheet" type="text/css">
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
<div class="center">
<%
	if(session.getAttribute("insufficient")!=null){
		%><p style="color:red;text-align:center;">You don't have sufficient balance</p><%
		session.setAttribute("insufficient", null);
	}
%>
<%
	if(session.getAttribute("Status")!=null){
		%><p style="color:red;text-align:center;">Some error have been occured try again later</p><%
		session.setAttribute("Status", null);
	}
	
%>
<%
	if(session.getAttribute("state")!=null){
		%><p style="color:red;text-align:center;">you have entered an invalid pin</p><%
		session.setAttribute("state",null);
	}
	
%>
      <h1>TRANSFER MONEY</h1>
      <form method="Post" action="BankTransfer">
        <div class="txt_field">
        <%
	if(session.getAttribute("accountfilter")!=null){
		%><p style="color:red;text-align:center;">ENTER VALID ACCOUNT NUMBER</p><%
		session.setAttribute("accountfilter", null);
	}%>
          <input name="accono" type="text" required placeholder="ENTER ACCOUNT NUMBER">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
        <%
	if(session.getAttribute("bankfilter")!=null){
		%><p style="color:red;text-align:center;">ENTER VALID BANK</p><%
		session.setAttribute("bankfilter", null);
	}%>
          <input name="bank" type="text" required placeholder="ENTER BANK">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
          <input name="ifsc" type="text" required placeholder="ENTER IFSC CODE">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
        <%
	if(session.getAttribute("amountfilter")!=null){
		%><p style="color:red;text-align:center;">ENTER VALID AMOUNT</p><%
		session.setAttribute("amountfilter", null);
	}%>
          <input name="amount" type="text" required placeholder="ENTER AMOUNT">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
        <%
	if(session.getAttribute("pinfilter")!=null){
		%><p style="color:red;text-align:center;">ENTER VALID PIN</p><%
		session.setAttribute("pinfilter", null);
	}%>
          <input type="password" name="pin" placeholder="ENTER YOUR PIN" required>
          <span></span>
          <label></label>
        </div>
        <input type="submit" value="TRANSFER">
        <div><h1></h1></div>
      </form>
    </div>
</body>
</html>