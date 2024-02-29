package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response_image")
public class MIMETypeImageResponseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		String imageFilePath="C:\\Users\\itwill\\Desktop\\repositories\\Eclipse-sts\\wokrspace-spring-toll-suite\\htmlSite\\src\\main\\webapp\\image\\male.jpg";
		FileInputStream imageInputStream = new FileInputStream(imageFilePath);
		while(true) {
			int readByte = imageInputStream.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		imageInputStream.close();
		out.close();
		
	}
}
