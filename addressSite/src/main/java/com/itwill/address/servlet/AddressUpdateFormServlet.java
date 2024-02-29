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

/**
 * Servlet implementation class AddressInsertActionServlet
 */
@WebServlet("/address_update_form")
public class AddressUpdateFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String no = req.getParameter("no");
		if(no==null||no.equals("")) {
			resp.sendRedirect("address_list");
			return;
		}
		AddressService addressService = new AddressService();
		Address address = addressService.addressDetail(Integer.parseInt(no));
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>["+address.getName()+"님 주소록 수정폼]</h1><hr>");
		out.println("<hr>");
		out.println("	<div>");
		out.println("		<a href='address_list'>[주소록리스트]</a>");
		out.println("	</div>");
		out.println("	<form method='post' action='address_update_action'>");
		out.println("		번호----"+address.getNo()+"<input type='hidden' name='no' value="+address.getNo()+"><br> "); 
		out.println("		이름----<input type='text' name='name' value='"+address.getName()+"'><br>"); 
		out.println("		전화번호<input type='text' name='phone' value='"+address.getPhone()+"'><br>"); 
		out.println("		주소----<input type='text' name='address' value='"+address.getAddress()+"'><br> ");
		out.println("		<input type='submit' value='주소록수정'>");
		out.println("		<input type='reset' value='주소록수정폼지우기'>");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}