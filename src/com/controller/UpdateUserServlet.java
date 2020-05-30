package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");

		UserBean bean = new UserBean();
		bean.setUserId(userId);
		bean.setFirstName(firstName);
		bean.setEmail(email);

		UserDao dao = new UserDao();
		dao.updateUser(bean);

		response.sendRedirect("ListUserController");
	}

}
