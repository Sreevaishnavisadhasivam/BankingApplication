<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
  <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <script type="text/javascript" src="validation.js"></script>
  <%@page import ="com.Banking.Main" %>
</head> 
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0"); %>
<% Main m=new Main();
   Main.getConnection();%>
    <div class="center">
    <%
	if(session.getAttribute("failed")!=null){
		%><div class="txt_field"><p style="color:red;text-align:center;">INVALID LOGIN</p></div><%
		session.setAttribute("failed", null);
	}
    %>
      <h1>LOGIN</h1>
      <form name="userlogin" method="post" action="Userlogin" onsubmit="userLoginValidateForm()">
        <div class="txt_field">
        <%
	if(session.getAttribute("emailfilter")!=null){
		%><p style="color:red;text-align:center;">Enter valid mail</p><%
		session.setAttribute("emailfilter", null);
	}
    %>
          <input name="email" id="email" type="email" required placeholder="ENTER YOUR EMAIL ADDRESS">
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
          <input name="password" id="password" type="password" placeholder="PASSWORD" required>
          <span></span>
          <label></label>
        </div>
        <div class="txt_field">
        <%
	if(session.getAttribute("mobilefilter")!=null){
		%><p style="color:red;text-align:center;">Enter valid mobileno</p><%
		session.setAttribute("mobilefilter", null);
	}
    %>
          <input name="mobileno" id="mobile" type="mobile" placeholder="MOBILE NUMBER" required>
          <span></span>
          <label></label>
        </div>
        <input type="submit" value="Login">
        <div><h1></h1></div>
      </form>
    </div>

  </body>
</html>