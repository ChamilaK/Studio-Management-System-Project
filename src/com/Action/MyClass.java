package com.Action;

import java.sql.*;

public class MyClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studio_Management_System","root","");
		System.out.println("Connected");

	}

}
