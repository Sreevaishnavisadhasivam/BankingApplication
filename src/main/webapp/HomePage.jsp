<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import ="com.Banking.Main" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate"); // HTTP 1.1.
  response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
  response.setDateHeader("Expires", 0);%>
<% Main m=new Main();
   Main.getConnection();%>
<div class="center">
<form action="AdminLogin.jsp">
<h1>HOME</h1>
<h1></h1>
<input type="submit" value="ADMIN">
</form>
<h1></h1>
<form action="BranchAdminLogin.jsp">
<input type="submit" value="CORPORATE LOGIN">
<h1></h1>
</form>
<form action="UserLogin.jsp">
<input type="submit" value="ACCOUNT HOLDER">
<h1></h1>
</form>
</div>
</body>
</html>