package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

 
public class ServletThreadServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(request.getRemoteAddr()+" 님의 요청에의해 "+
				request.getLocalAddr()+" [강사서버]에서 할당된 쓰레드는 "+ currentThreadName+" 입니다.");
		System.out.println(request.getLocalAddr()+" [강사서버]에서 "+
				request.getRemoteAddr()+" 님의 브라우져로 응답합니다.");
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(request.getRemoteAddr()+" 님의 요청에의해 "+
				request.getLocalAddr()+" [강사서버]에서 할당된 쓰레드는 "+ currentThreadName+" 입니다.");
		out.println(request.getLocalAddr()+" [강사서버]에서 "+
				request.getRemoteAddr()+" 님의 브라우져로 응답합니다.");
		return;
		//웹서버 톰캣이 호출했으니 다시 반환
	}

}
