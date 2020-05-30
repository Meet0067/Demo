package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	    
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));

		UserDao dao = new UserDao();
		dao.deleteUser(userId);
		response.sendRedirect("ListUserController");
	
		}

}
