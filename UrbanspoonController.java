package com.ts.us.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ts.us.dao.MyUser;
import com.ts.us.services.RestaurantService;
import com.ts.us.services.UserService;



@WebServlet("/urbanspoonController")
public class UrbanspoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UrbanspoonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		boolean b=ServletFileUpload.isMultipartContent(request);
		if(b){
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sf=new ServletFileUpload(factory);
		try {
			List<FileItem> lf=sf.parseRequest(request);
			Iterator<FileItem> it=lf.iterator();
			FileItem ft=it.next();
			String fName=ft.getFieldName();
			if(fName.equals("action") && ft.getString().equals("registerForm")){
				  while(it.hasNext()){
					  try {
						RestaurantService.getRestaurantInfo(it.next());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
						RestaurantService.service(response);

				  }
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}	
		}else{
		String action=request.getParameter("action");
			if(action!=null){
				if(action.equals("userForm")){
					String uname=request.getParameter("name");
					String password=request.getParameter("pwd");
					String gender=request.getParameter("gender");
					String email=request.getParameter("email");
					String mno=request.getParameter("mno");
					String dob=request.getParameter("dob");
					MyUser user1=new MyUser();
					user1.setUname(uname);
					user1.setPassword(password);
					user1.setGender(gender);
					user1.setEmail(email);
					user1.setMno(Long.parseLong(mno));
					user1.setDate(java.sql.Date.valueOf(dob));
					int no=UserService.getUserForm(user1);
					if(no>=1) {
						RequestDispatcher rd=request.getRequestDispatcher("index.html");
						rd.forward(request, response);
					}
				}
			}
		}


	
		
	}

}
