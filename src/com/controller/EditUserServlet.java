package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		int userId = Integer.parseInt(request.getParameter("userId"));
			UserDao ud = new UserDao();
			
			UserBean user = ud.getDataByPk(userId);
			request.setAttribute("user", user);
			HttpSession session=request.getSession();
			if(session.getAttribute("isAdmin").toString().equals("true")) {
			RequestDispatcher rd = request.getRequestDispatcher("EditUser.jsp");
			rd.forward(request, response);
			}
			if(session.getAttribute("validUser").toString().equals("true")) {
				RequestDispatcher rd = request.getRequestDispatcher("PasswordChange.jsp");
				rd.forward(request, response);
				}
	}

}
