package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response_mp3")
public class MIMETypeMP3ResponseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("audio/mpeg");
		OutputStream out = response.getOutputStream();
		String imageFilePath="C:\\Users\\itwill\\Desktop\\repositories\\Eclipse-sts\\wokrspace-spring-toll-suite\\servletSite\\src\\main\\webapp\\images\\test.mp3";
		FileInputStream mp3InputStream = new FileInputStream(imageFilePath);
		while(true) {
			int readByte = mp3InputStream.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		mp3InputStream.close();
		out.close();
		
	}
}
