package com.ts.us.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ts.us.dao.LoginDao;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		String loginas = request.getParameter("loginAs");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		LoginDao l = new LoginDao();
		int i =l.validate(uname, pass, loginas);
		System.out.println(i);
		if(i == 0) {
			out.print("<html> invalid username and password </html>");
			RequestDispatcher rd =request.getRequestDispatcher("login1.html");
						rd.include(request, response);
		}
		else if(i == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("userHomepage.html");
			rd.forward(request, response);
		}
		else if (i == 2) {
			out.print("<html>invalid username and password</html>");
			RequestDispatcher rd =request.getRequestDispatcher("login1.html");
						rd.include(request, response);
		}
		else if (i == 3) {
			RequestDispatcher rd = request.getRequestDispatcher("restauranthomepage.html");
			rd.forward(request, response);
		}
	
	
	}
	}


