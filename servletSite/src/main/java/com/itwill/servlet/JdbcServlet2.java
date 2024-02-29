package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressService;
import com.itwill.common.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jdbc2")
public class JdbcServlet2 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * 1.Service객체생성
			 */
			AddressService addressService = new AddressService();
			/*
			 * 2.Service객체 메소드 실행
			 */
			List<Address> addressList = addressService.addressList();
			/*
			 * 3.클라이언트로 출력
			 */
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			DataSource dataSource = new DataSource();
			Connection con = dataSource.getConnection();
			String selectSql = "select no,name,phone,address from address order by no";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectSql);

			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 1◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");			
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			for(Address address:addressList) {
				out.println("<tr class=t1>");
				out.printf("<td align=center width=25%% height=20>%d</td>",address.getNo());
				out.printf("<td align=center width=25%% height=20>%s</td>",address.getName());
				out.printf("<td align=center width=25%% height=20>%s</td>",address.getPhone());
				out.printf("<td align=center width=50%% height=20>%s</td>",address.getAddress());
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end service

}
