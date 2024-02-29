package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		for(int i=0;i<100;i++) {
		out.println("<h4>Hello Servlet(안녕서블릿)["+i+"]</h4><hr>");
		}
		out.println("</body>");
		out.println("</html>");
		/*
		 * <!DOCTYPE html>
			<html>
				<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
				</head>
				<body>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
					<h1>Hello Servlet(안녕서블릿)</h1><hr>
				</body>
			</html>
		 */
	}

}
