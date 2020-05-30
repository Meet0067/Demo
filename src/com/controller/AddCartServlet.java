package com.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.bean.ProductBean;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet{

		protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			int uid = (Integer)session.getAttribute("userId");
			String productId  = (String)request.getParameter("productId");
			
			ServletContext context = getServletContext();
		
			ArrayList<CartBean> carts = (ArrayList<CartBean>)context.getAttribute("carts");
			ArrayList<ProductBean> products = (ArrayList<ProductBean>)context.getAttribute("products");
			ProductBean m = null;
			for(ProductBean p : products)
			{	
					if(p.getProductId() == Integer.parseInt(productId))
					{
						m = p;
						break;
					}
			}
			boolean isExist = false;
			CartBean temp =null;
			for(CartBean x : carts) {
				if(x.getProduct().getProductId()==Integer.parseInt(productId) && uid == x.getUserId()) {
					temp = x;
					isExist = true;
				}
			}
			if(!isExist) {
				CartBean c = new CartBean();
				c.setCartId((int)(Math.random()*100));
				c.setProduct(m);
				c.setUserId(uid);
				carts.add(c);
				c.setQty(1);	
			}else {
				int Qty = temp.getQty();
				temp.setQty(temp.getQty() + 1);
			}
			context.setAttribute("carts", carts);
			response.sendRedirect("ShoppingHome.jsp");
			
		}
}