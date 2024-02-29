package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address_detail")
public class AddressDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		/*
		 * 요청URL
		 *   http://localhost/addressSite/address_detail?no=1
		 *   http://localhost/addressSite/address_detail?no=2
		 *   http://localhost/addressSite/address_detail?no=3
		 *   http://localhost/addressSite/address_detail?no=4
		 *   http://localhost/addressSite/address_detail?no=5
		 */
			
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.AddressService객체생성
		 * 3.AddressService객체 addressDetail(1) 메쏘드호출
		 * 4.Address객체 출력
		 */
		req.setCharacterEncoding("UTF-8");
		String noStr = req.getParameter("no");
		
		if(noStr==null||noStr.equals("")) {
			resp.sendRedirect("address_list");
			return;
		}
		AddressService addressService = new AddressService();
		Address address = addressService.addressDetail(Integer.parseInt(noStr));
		/*
		if(address==null) {
			resp.sendRedirect("address_list");
			return;
		}
		*/
			
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		req.getParameter("");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<h1>[%s님 주소록상세보기]</h1><hr>",address.getName());
		out.println("<div>");
		out.printf("	<a href='address_delete_action?no=%d'>%s님삭제[GET]</a>",address.getNo(),address.getName());
		out.printf("	<a href='address_update_form?no=%d'>[%s님 주소록수정폼]</a>",address.getNo(),address.getName());
		out.println("	<a href='address_insert_form'>[주소록쓰기폼]</a>");
		out.println("<form action='address_delete_action' method='post' style='display: inline'>");
		out.println("<input type=\"hidden\" name=\"no\" value=\""+address.getNo()+"\">");
		out.println("<input type=\"submit\" value=\""+address.getName()+"님삭제[POST]\">");
		out.println("</form>");
		out.println("	<a href='address_list'>[주소록리스트]</a>");
		out.println("</div>");
		out.println("<p>");
		out.printf("	번호:%d<br>",address.getNo());
		out.printf("	이름:%s<br>",address.getName());
		out.printf("	전화:%s<br>",address.getPhone());
		out.printf("	주소:%s<br>",address.getAddress());
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("address_error.html");
		}
	}
}