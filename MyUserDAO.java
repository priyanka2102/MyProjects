package com.ts.us.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ts.us.dao.MyUser;

public class MyUserDAO {
	public  static int insertRecord(MyUser user1) {
		int no=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/urbanspoon";
			String user="root";
			String pwd="sheel21";
				Connection con=DriverManager.getConnection(url,user,pwd);
				String query="insert into user(name,gender,email,password,date_of_birth,mobile_number)values(?,?,?,?,?,?)";
				System.out.println(query+"query");
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1,user1.getUname());
				pstmt.setString(2,user1.getGender());
				pstmt.setString(3,user1.getEmail());
				pstmt.setString(4, user1.getPassword());
				//java.sql.Date date=java.sql.Date.valueOf(dob);
				pstmt.setDate(5,user1.getDate());
				//long mobile_number=Long.parseLong(mno);
				pstmt.setLong(6,user1.getMno());
				no=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return no;
		
	}


}
