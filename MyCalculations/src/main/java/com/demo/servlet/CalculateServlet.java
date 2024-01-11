package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private int factorial(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		
		return n * factorial(n-1);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String op = request.getParameter("btn");
		int result = 0;
		
		switch(op) {
		case "add":
			int num2 = Integer.parseInt(request.getParameter("num2"));
			result = num1 + num2;
			out.println("<p>Addition of "+ num1 +" and "+ num2 +" is" + result+"</p>");
			break;
		case "fact":
			result = factorial(num1);
			out.println("<p>Factorial of " + num1 + " is " + result+ "</p>");			
			break;
		}
		
//		out.println("<h3>"+ result +"</h3>");
	}

}
