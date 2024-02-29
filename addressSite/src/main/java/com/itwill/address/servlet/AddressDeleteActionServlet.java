package com.itwill.address.servlet;

import java.io.IOException;

import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address_delete_action")
public class AddressDeleteActionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String no = req.getParameter("no");
			if(no==null||no.equals("")) {
				resp.sendRedirect("address_list");
				return;
			}
			AddressService addressService = new AddressService();
			addressService.addressDelete(Integer.parseInt(no));
			resp.sendRedirect("address_list");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String no = req.getParameter("no");
			if(no==null||no.equals("")) {
				resp.sendRedirect("address_list");
				return;
			}
			AddressService addressService = new AddressService();
			addressService.addressDelete(Integer.parseInt(no));
			resp.sendRedirect("address_list");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
