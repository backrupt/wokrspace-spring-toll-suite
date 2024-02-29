package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		/*
		 * 클라이언트요청 URL
		 * - http://localhost/search?searchKeyword=java
		 * - http://localhost/search?searchKeyword= 
		 * - http://localhost/search 
		 */
		
		/*
		 * 1.요청객체를사용해서 요청시 전송되는 쿼리스트링에 있는 파라메타받기
		 * 	- 파라메타이름은 input element의 name속성과일치
		 * 		<input type="text" name="searchkeyword">
		 * 	- search.do?searchkeyword=java
		 */
		String searchKeyword = req.getParameter("searchKeyword");
		/*
		 * searchKeyword null ==> search?
		 * searchKeyword "" ==> search?searchKeyword=
		 */
		if(searchKeyword==null||searchKeyword.equals("")) {
			out.println("검색어를 입력하지 않은 경우 재미있는 지식 결과를 랜덤하게 보여드립니다.");
			out.println("<a href='05-00.search_form.html'>검색페이지</a>");
			return;
		}
		/*
		 * 2.검색업무실행 --> Service객체사용
		 */
		/*
		 * 3.클라이언트로 검색결과 전송
		 */
		out.println("<h1>"+searchKeyword+" 검색결과</h1>");
		out.println("<ol>");
		int searchResultCount = (int)(Math.random()*10);
		for(int i=0;i<searchResultCount;i++) {
			out.println("<li>"+searchKeyword+" 의 검색결과</li>");
		}
		out.println("</ol>");
		out.println("<a href='05-00.search_form.html'>검색페이지</a>");
	}
}
