package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//#1. javax.servlet.http.HttpServlet 클래스를 상속 받아야한다.
public class GugudantTextServlet extends HttpServlet {

	//#2. HttpServlet service 메소드를 오버라이딩 해야한다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#2-1. 클라이언트에 전송할 데이터의 타입(종류)설정
		response.setContentType("text/plain;charset=UTF8");
		//#2-2. 클라이언트에 데이터를 전송하기위한 출력스트림 생성
		PrintWriter out = response.getWriter();
		//#2-3. 클라이언트로 데이터(text) 전송
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				out.printf("%d * %d = %d\t",j,i,j*i);
			}
			out.println();
		}
	}

}
