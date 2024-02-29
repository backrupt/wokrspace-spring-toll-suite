package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class GugudanServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<meta charset='UTF-8'>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src=\"https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002487]_20210426091745467.jpg\"/>");

		out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		for(int i=1;i<=9;i++) {
			out.println("<tr>");
			for(int j=2;j<=9;j++) {
				out.printf("<td align=center>%d*%d=%d</td>\n",j,i,i*j);
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
