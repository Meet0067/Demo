package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet(value = "/Registration")
public class Registration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName= (String) req.getParameter("firstName");
		String email=(String) req.getParameter("email");
		String password=(String) req.getParameter("password");
		System.out.println(firstName + " " + email + " " + password );
		UserBean userBean=new UserBean();
		int uId=(int)(Math.random()*100);
		
		userBean.setFirstName(firstName);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setUserId(uId);
		
		UserDao userDao=new UserDao();
		try{
		boolean b=userDao.insertUser(userBean);
		System.out.println(b);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("userId",uId);
		session.setAttribute("validUser","true");
		
		resp.sendRedirect("ShoppingHome.jsp");
	
	}
}
