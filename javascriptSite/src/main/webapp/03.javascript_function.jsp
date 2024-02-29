<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String name="김수한무";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/*
	 함수정의
	   - 윈도객체에소속된 함수가된다.
	 */
	let name='block scope <%=name%>';
	let msg='block scope 아직도 12척의 배가 있습니다.';
	function head_function(){ //자바스크립트는 함수를 인자로 주고받기 가능
		window.document.write('head_function()<%= new Date()%>'+msg+'<br>');
		return;
	}
	function hello1(){
		let name='local scope 이순신';
		let msg='local scope 아직도 12척의 배가 있습니다.';
		document.write(name+"님"+msg+'[hello1]<br>');
	}
	/*********************function argument*****************************/
	function hello2(msg){
		/*
		메소드 파라메타 선언시 let 키워드 사용안함
		*/
		document.write(name+" 님 "+msg+"[hello2(msg)]<br>");
	}
	//function hello2(){  //에러는 안나지만 overwrite돼서 hello2()가 남음}
	function hello3(name,msg){
		document.write(name+"님 "+msg+" [hello3(name,msg)]<br>");
	}
	function hello4(name,msg,count){
		if(count==undefined){
			count=1;
		}
		for(let i=0;i<count;i++){
		document.write(name+"님 "+msg+" [hello4(name,msg,"+(i+1)+")]<br>");			
		}
	}
	/******************function return***********************/
	function add(a,b){
		return a+b;
	}
	function sub(a,b){
		return a-b;
	}
	function mul(a,b){
		return a*b;
	}
	function div(a,b){
		return a/b;
	}
	function alert(msg){
		document.write('<i>내가만든경고함수 '+msg+'</i><br>');
	}
	
</script>

</head>
<body>
<h1>자바스크립트함수</h1><hr>
<div>함수기반언어이다</div>
<script type="text/javascript">
	//함수호출
	window.head_function();
	head_function();
	//body_end_function();
	hello1();
	hello2('뭐하세요');
	hello2('안녕하슈');
	window.hello3('야임마','안녕하슈');
	hello4('이소라','안녕하수꽝',10);
	let result = add(1,2);
	document.write('add result:',result,'<br>');
	document.write('sub result:',sub(1,2),'<br>');
	document.write('mul result:',mul(1,2),'<br>');
	document.write('div result:',div(1,2),'<br>');
	alert('경고!!');
</script>

<script type="text/javascript">
	function body_end_function(){
		document.write('body_end_function()<br>');
	}
</script>
</body>
</html>