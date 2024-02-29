<%@ page contentType="text/html; charset=UTF-8" %>
<%!
int count=0;
public void jspInit(){
	System.out.println("1.init 메소드 -> 생성자 호출 직후에 단 한번 호출[객체초기화, 리소스획득] ");
}
public void jspDestroy(){
	System.out.println("3.destroy 메소드 -> 서블릿객체가 메모리에서 해제되기직전에 호출 [리소스반납] ");
	
}
%>
<%
	System.out.println("2.service 메소드 실행[요청시마다 호출]:"+this);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor=#40e0d0 style="font-size: 9pt; line-height: 140%;">
	<center>
		현재까지의 페이지뷰수 <font color=#0000FF> 
		<%
			out.println(++count);
		%>
		 </font> 번입니다
	</center>
</body>
</html>
<!-- 
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> 13 </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");


 -->
