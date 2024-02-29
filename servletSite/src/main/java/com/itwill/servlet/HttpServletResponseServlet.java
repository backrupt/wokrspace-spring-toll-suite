package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println(req);
		/*
		 * http://192.168.15.31/response?cmd=1
		 * http://192.168.15.31/response?cmd=2
		 * http://192.168.15.31/response?cmd=3
		 * http://192.168.15.31/response?cmd=3312311231
		 * http://192.168.15.31/response?cmd=   ==> ""
		 * http://192.168.15.31/response 		==> null
		 */
		
		String cmd = req.getParameter("cmd");
		if(cmd==null||cmd.equals("")) {
			/*****************case1****************
			out.println("<h1>다시요청하세요</h1><hr>");
			out.println("<a href='04.HttpServletResponse.html'>04.HttpServletResponse.html</a>");
			********************************************/
			/******************case2*******************/
			resp.sendRedirect("04.HttpServletResponse.html");
			return;
		}
		
		if(cmd.equals("1")) {
			/*
			 * 정상응답
			 * 	1. 응답라인 상태코드 200
			 * 	2. 응답헤더 
			 * 	3. 응답바디데이터전송
			 */
			out.println("<h3>정상응답</h3><hr>");
		} else if(cmd.equals("2")) {
			/*
			 * 에러응답
			 * 	1. 응답라인 상태코드 4XX,5XX
			 * 	2. 응답헤더 
			 * 	3. 응답바디데이터없음(보낼수없음)
			 */
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//resp.sendError(404);
		} else if(cmd.equals("3")) {
			/*
			 * redirect[방향재지정]응답
			 * 	1. 응답라인 302
			 * 	2. 응답헤더[Location:05-03.form1.html(redirection url)이 포함]
			 * 	3. 응답바디데이터없음(보낼수없음)
			 */
			resp.sendRedirect("index.html");
			
		}
	}
}
