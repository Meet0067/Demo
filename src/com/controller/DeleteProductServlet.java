package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ShoppingDeleteProductServlet
 */
@WebServlet("/ShoppingDeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao ud = new UserDao();
		String id = request.getParameter("productId");
		int pid = Integer.parseInt(id);

		ServletContext context = getServletContext();
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) context.getAttribute("products");
		ProductBean tmp = null;
		for (ProductBean p : products) {
			if (p.getProductId() == pid) {
				tmp = p;// products.remove(p);
				break;
			}
		}
		ud.deleteProduct(pid);
		products.remove(tmp);
		context.setAttribute("products", products);

		response.sendRedirect("ListProducts.jsp");

	}


}
