package com.Banking;
import java.sql.*;
public class Main 
{
 public static Connection con;
 public static void getConnection() throws ClassNotFoundException, SQLException
 {
	   Class.forName("com.mysql.cj.jdbc.Driver"); 
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
 }

}
