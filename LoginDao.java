package com.ts.us.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {
public int validate (String uname,String pass,String loginas) {
		
		if(loginas.equals("USER")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/urbanspoon";
			String username="root";
			String pwd="sheel21";
				try {
					Connection con=DriverManager.getConnection(url,username,pwd);
					PreparedStatement rs =con.prepareStatement("select * from user where name = ? and password = ?");
					 		rs.setString(1, uname);
					 		rs.setString(2, pass);
					 		java.sql.ResultSet e =	rs.executeQuery();
					 		int i = 0;
					 		while(e.next()) {
					 			i = 1;
					 		}
					 		return i;
					}
					
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if(loginas.equals("OWNER")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/urbanspoon";
			String username="root";
			String pwd="sheel21";
				try {
					Connection con=DriverManager.getConnection(url,username,pwd);
					PreparedStatement rs =con.prepareStatement("select * from restaurant where name = ? and password = ?");
					 		rs.setString(1, uname);
					 		rs.setString(2, pass);
					 		java.sql.ResultSet e =	rs.executeQuery();
					 		int i = 2;
					 		while(e.next()) {
					 			i = 3;
					 		}
					 		return i;
					}
					
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return 0;
	}


}
