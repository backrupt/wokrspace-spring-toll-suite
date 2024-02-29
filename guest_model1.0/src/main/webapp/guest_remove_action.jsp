<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
   GET방식이면 guest_main.jsp redirection
   
  0.요청객체encoding설정
  1.파라메타받기(guest_no)
  2.GuestService객체생성
  3.GuestService객체 deleteGuest(guest_no) 메쏘드호출
  4.guest_list.jsp로 redirection
 */
 
 
 	request.setCharacterEncoding("UTF-8");

	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	String no = request.getParameter("guest_no");
	GuestService guestService = new GuestService();
	guestService.guestDelete(Integer.parseInt(no));
	response.sendRedirect("guest_list.jsp");
	return;
%>