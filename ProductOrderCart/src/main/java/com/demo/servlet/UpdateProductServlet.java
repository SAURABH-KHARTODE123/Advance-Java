package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/editproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		MyUser user = (MyUser) session.getAttribute("user");
		if(user != null && user.getRoles().equals("admin")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductService ps=new ProductServiceImpl();
			Product p=ps.getById(pid);
			out.println("<h3>Welcome "+user.getUser_name()+"</h3>");
			
			out.println("<form action='updateproduct' method='post'>");
			out.println("Product Id: <input type='text' name='pid' id='pid' value='"+p.getId()+"' readonly><br>"); 
			out.println(" Product Name:<input type='text' name='pname' id='pname' value='"+p.getName()+"'><br>");   
			out.println("Quantity : <input type='text' name='qty' id='qty' value='"+p.getQty()+"'><br>"); 
			out.println(" Price: <input type='text' name='price' id='price' value='"+p.getPrice()+"'><br>");  
			out.println("<button type='submit' name='btn' id='btn'>Update Product</button>");  
			out.println("</form>");
		}
		else {
			out.println("Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
