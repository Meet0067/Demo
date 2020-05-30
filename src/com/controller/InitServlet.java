package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CartBean;
import com.bean.ProductBean;
import com.bean.UserBean;
import com.dao.UserDao;

public class InitServlet extends HttpServlet {
	

	ArrayList<CartBean> carts = new ArrayList<CartBean>();
	ArrayList<ProductBean> products = new ArrayList<ProductBean>();
	ArrayList<UserBean> users = new  ArrayList<UserBean>();

	public void init()  throws ServletException {
    	System.out.print("////////////////////////////////");
		ServletContext context = getServletContext();
		context.setAttribute("users", users);
		UserDao ud = new UserDao();
		products = ud.getProducts();
		
		System.out.println("=====================================================================");
		context.setAttribute("products",products);
    	context.setAttribute("carts",carts);
    	
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
   }
