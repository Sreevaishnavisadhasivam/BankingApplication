<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="Home.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <%@ page import="com.Banking.SmartTransaction,com.Banking.NetBanking"%>
    <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
    <%@page import="java.util.Iterator"%> 
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
    <%@page import ="com.Banking.Main" %>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CORPORATE USER HOME</title>
    <style>

    </style>
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
<form id="logout" action="Logout" method="get"></form>
<form id="profile" action="UserProfile" method="get"></form>
<div class="row">
    <div class="col-3">
    <div class="wrapper">
        <div class="sidebar">
            <ul>
            <li>
                        <div class="dropup">
                        <button class="dropbtn">PROFILE</button>
                        <div class="dropup-content">
					    <button class="Button" form="profile"> PROFILE</button>
                        </div>
                        </div>

                </li>
                <hr>
                <li>
                        <div class="dropup">
                        <button class="dropbtn">SERVICES</button>
                        <div class="dropup-content">
                        <button><a href="SmartServices.jsp">SMART TRANSACTION SERVICE</a></button>
                        </div>
                        </div>
                </li>
                <hr>
                <li>
                
                <% SmartTransaction netbank=new SmartTransaction();%>
                <% String Gmail=(String)session.getAttribute("Email"); %>
                <% ArrayList<NetBanking> NetBank = netbank.netbankingService(Gmail);%>
                <%if(NetBank.size()!=0) {%>
                        <div class="dropup">
                        <button class="dropbtn">TRANSACTION</button>
                        <div class="dropup-content">
                        <button><a href="TransferMoney.jsp">BANK TRANSFER MONEY</a></button>
					    <button><a href="TransactionHistory.jsp">TRANSACTION HISTORY</a></button>
					    <button><a href="CheckBalance.jsp">CHECK BALANCE</a></button>
                        </div>
                        </div>
                        <%}%>
                </li>
                <hr>
                <li>
                        <div class="dropup">
                        <button class="dropbtn">PRIVACY</button>
                        <div class="dropup-content">
                        <button><a href="ChangeUserPassword.jsp">CHANGE PASSWORD</a></button>
                        </div>
                        </div>
                    </a>
                </li>
                <hr>
                <li>
                        <button form="logout" class="dropbtn">LOGOUT</button>
                </li>
                <hr>
             </ul>
        </div>
   </div>
    
    </div>
    <div class="col-8">
    </div>
    </div>
    </body>
</html>
