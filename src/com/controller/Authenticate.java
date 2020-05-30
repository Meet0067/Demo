package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/Authenticate")
public class Authenticate  extends HttpServlet {

	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext context = getServletContext();
		UserDao ud = new UserDao();
	//	ArrayList<UserBean> users = (ArrayList<UserBean>)context.getAttribute("users");
		ArrayList<UserBean> users = ud.getUsers();
		
		int uId  =0;
		boolean isError = false, isAdmin=false;
		String email = (String)request.getParameter("email");
		String password = (String)request.getParameter("password");
		int count =0 ;
		HttpSession session = request.getSession();
		RequestDispatcher rd =null;
		ServletConfig config = getServletConfig();
		//String emailA = config.getInitParameter("email");
		//String passA = config.getInitParameter("password");
		//System.out.println(emailA+"        "+passA);
		String emailA="admin@admin.com";
		String passA="admin";
		for(UserBean  u : users) {
				System.out.println(u.getEmail() +" ////////" +  u.getPassword());

				
		}System.out.println("out from loop");
		
		System.out.println(email);
		System.out.println(password);
		if(email.equals(emailA) && password.equals(passA)) {
			session.setAttribute("isAdmin", "true");
			isAdmin = true;
			response.sendRedirect("AdminHome.jsp");
				
		}else {
			session.setAttribute("isAdmin", "false");
				for(UserBean  u : users) {
						System.out.println(u.getEmail() +" ////////" +  u.getPassword());
						if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
							 	uId = u.getUserId();
								count++;					
						}
				}
				if(count==1) {
					count=0;
					System.out.println("settting session");
					session.setAttribute("userId", uId);
					session.setAttribute("validUser", "true");
			
					response.sendRedirect("ShoppingHome.jsp");
					
				}
				else {
					request.setAttribute("email", email);
					request.setAttribute("password",password);
					request.setAttribute("LoginError", "Invalid Email or Password");
					rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
		}
	}
}
