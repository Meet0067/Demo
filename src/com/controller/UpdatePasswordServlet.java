package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserBean bean = new UserBean();
		bean.setUserId(userId);
		bean.setPassword(password);
		
		UserDao dao = new UserDao();
		dao.updateUserPW(bean);
		
		response.sendRedirect("ShoppingHome.jsp");
	}

}
