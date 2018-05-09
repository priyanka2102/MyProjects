package com.ts.us.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyRestaurantDAO {
	public int insertRecord(String govid,String name,String password,String path) throws SQLException {
		int no = 0;
		//step 1:register driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/urbanspoon";
			String user = "root";
			String pwd = "sheel21";
			Connection con = DriverManager.getConnection(url, user, pwd);
			String query = "insert into restaurant(govt_registration_id,name,password,logo_name) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,govid);
			pst.setString(2,name);
			pst.setString(3,password);
			pst.setString(4, path);
			no = pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return no;
		
	}

}
