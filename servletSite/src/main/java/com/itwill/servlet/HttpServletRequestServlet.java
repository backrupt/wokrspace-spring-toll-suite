package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class HttpServletRequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String method = request.getMethod();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String remoteAddress = request.getRemoteAddr();
		String queryString = request.getQueryString();
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		out.println("<h1>HttpServletRequest객체</h1><hr>");
		out.println("<ol>");
		out.println("<li>요청메소드:"+method+"</li>");
		out.println("<li>요청URL:"+url+"</li>");
		out.println("<li>요청URI:"+uri+"</li>");
		out.println("<li>요청contextPath:"+contextPath+"</li>");
		out.println("<li>remoteAddress:"+remoteAddress+"</li>");
		out.println("<li>---------요청시전송된 파라메타----------</li>");
		out.println("<li>queryString:"+queryString+"</li>");
		out.println("<li>name 파라메타 값:"+name+"</li>");
		out.println("<li>phone 파라메타 값:"+phone+"</li>");
		out.println("<li>address 파라메타 값:"+address+"</li>");
		out.println("</ol>");
	}
}
