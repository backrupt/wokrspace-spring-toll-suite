<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("A.file_upload_form.jsp");
		return;
	}

/*
	file upload component사용
	 - MultipartRequest(javax.servlet.http.HttpServletRequest request,
			 			java.lang.String saveDirectory,
			 			int maxPostSize, 
			 			java.lang.String encoding)
	 
	 - MultipartRequest(javax.servlet.http.HttpServletRequest request,
			 			java.lang.String saveDirectory,
			 			int maxPostSize, 
			 			java.lang.String encoding, 
			 			FileRenamePolicy policy)
 */
 	String saveDirectory="";
	int maxPostSize = 1024*1024*100; 
	String encoding="UTF-8";
	//MultipartRequest multipartRequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding);
%> 
<h1>Upload Data</h1><hr/>
<br/>
<br/>
<br/>
<li>name:xxx</li>
<li>fileone:file1</li>
<li>filetwo:file2</li>
