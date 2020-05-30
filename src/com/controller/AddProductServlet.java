package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.ProductBean;
import com.dao.UserDao;
//@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet{ 
	
	public static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		UserDao ud= new UserDao();
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String details = request.getParameter("details");
		System.out.println(price);
		System.out.println(pname);
		int p = Integer.parseInt(price);
		System.out.println(p);
		ServletContext context = getServletContext();// application
		ArrayList<ProductBean> products = (ArrayList<ProductBean>)context.getAttribute("products");
	
		ProductBean pr = new ProductBean();
		int pid = (int)(Math.random()*100);
		pr.setProductId(pid);
		pr.setName(pname);
		pr.setPrice(p);
		pr.setDetails(details);
		try {
			ud.insertProduct(pr);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pr.getProductId());
		System.out.println(pr.getName());
		System.out.println(pr.getPrice());
		System.out.println(pr.getDetails());
		products.add(pr);
	/*	String realPath = "";
		String savePath =null;
		try {
			realPath = request.getServletContext().getRealPath("/"); 
			System.out.println("realPth =>" + realPath);
			savePath=realPath +"images";
			System.out.println(savePath);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		
			 for (Part parts : request.getParts()) {
				 String fileName =extractFileName(parts);
		            
		            fileName = new File(fileName).getName();
		            parts.write(savePath + File.separator + fileName);
		            
			 }
			
		
*/
				context.setAttribute("products", products);
				response.sendRedirect("ListProducts.jsp");
			

	}


}
