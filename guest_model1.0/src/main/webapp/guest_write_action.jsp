<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	GET방식이면 guest_main.jsp redirection

  0.요청객체encoding설정
  1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content)
     Guest객체생성
  2.GuestService객체생성
  3.GuestService객체 insertGuest(Guest객체) 메쏘드호출
  4.guest_list.jsp로 redirection
 */
	
 	request.setCharacterEncoding("UTF-8");
	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	String name = request.getParameter("guest_name");
	String email = request.getParameter("guest_email");
	String homppage = request.getParameter("guest_homepage");
	String title = request.getParameter("guest_title");
	String content = request.getParameter("guest_content");
	Guest guest = Guest.builder()
							.guestName(name)
							.guestEmail(email)
							.guestHomepage(homppage)
							.guestTitle(title)
							.guestContent(content)
							.build();
	GuestService guestService = new GuestService();
	int guest_no = guestService.guestWrite(guest);
	response.sendRedirect("guest_view.jsp?guest_no="+guest_no);
	return;
%>