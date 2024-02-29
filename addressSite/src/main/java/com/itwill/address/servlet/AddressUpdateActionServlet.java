package com.itwill.address.servlet;

import java.io.IOException;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address_update_action")
public class AddressUpdateActionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendError(405, "GET방식의 요청입니다..");
		resp.sendRedirect("address_main");
		return;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			/*
			 * 0.요청객체 encoding설정
			 * 1.파라메타 받기(no,name,phone,address)
			 * 3.AddressService객체 생성
			 * 4.AddressService.update()메소드 실행
			 * 5-1.address_detail?no=3 로 redirection
			 * 5-2.address_list        로 redirection
			 */
			req.setCharacterEncoding("UTF-8");
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		AddressService addressService = new AddressService();
		addressService.addressUpdate(Address.builder()
											.no(Integer.parseInt(no))
											.name(name)
											.phone(phone)
											.address(address)
											.build());
		resp.sendRedirect("address_detail?no="+no);
		return;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
