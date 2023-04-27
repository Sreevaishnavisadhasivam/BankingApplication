<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@page import ="com.Banking.Main" %>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="topnav">
  <a href="UserHome.jsp">HOME</a>
</div>
<% Main m=new Main();
   Main.getConnection();%>
<%
	if(session.getAttribute("Email")==null){
		response.sendRedirect("HomePage.jsp");
	}
%>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0"); %>
<div class="center">
      <h1>CHANGE PASSWORD</h1>
      <form name="changepassword"method="post" action="ChangeUserPassword">
        <div class="txt_field">
          <input name="oldpassword" type="password" required placeholder="ENTER YOUR OLD PASSWORD">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
          <input name="newpassword" type="password" required placeholder="ENTER YOUR NEW PASSWORD">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
        <%
	if(session.getAttribute("password")!=null){
		%><p style="color:red;text-align:center;">PASSWORD IS NOT SAME and it should be only 8 characters</p><%
		session.setAttribute("password", null);
	}
    %>
          <input name="password" type="password" required placeholder="RENTER YOUR NEW PASSWORD">
          <span></span>
          <label></label>
        </div>
        <input type="submit" value="change">
        <div><h1></h1></div>
      </form>
    </div>
</body>
</html>