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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addnewproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MyUser user = (MyUser) session.getAttribute("user");
		
		if(user != null) {
			ProductService ps = new ProductServiceImpl();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int qty = Integer.parseInt(request.getParameter("qty"));
			double price = Double.parseDouble(request.getParameter("price"));
			Product p = new Product(id,name,qty,price);
			
			boolean status = ps.addNewProduct(p);
			RequestDispatcher rd = request.getRequestDispatcher("displayproduct");
			rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
