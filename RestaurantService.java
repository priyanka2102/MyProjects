package com.ts.us.services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.ts.us.dao.MyRestaurantDAO;


public class RestaurantService {
	static String govtId;
	 static String name;
	 static String password;
	 static String path;
	public static void getRestaurantInfo(FileItem fi) throws Exception {
		String fieldName=fi.getFieldName();
		
		if(fieldName.equals("govid")){
			govtId=fi.getString();
		}else if(fieldName.equals("name")){
			 name=fi.getString();
		}else if(fieldName.equals("pwd")){
			password=fi.getString();
		}else if(fieldName.equals("logo")){
			String path1="C:/Users/user/workspace/PriyankaC10/Example/WebContent/";
			
			File file=new File(path1+"/"+fi.getName());
			fi.write(file);
			path = fi.getName().toString();
		}
	}
	
	public static void service(HttpServletResponse s) {
		MyRestaurantDAO rdao=new MyRestaurantDAO();
		int no=0;
		
		try {
			
			
		no = rdao.insertRecord(RestaurantService.govtId, RestaurantService.name, RestaurantService.password,RestaurantService.path);
		
		if(no > 0) {
			try {
				s.sendRedirect("index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
