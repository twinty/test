<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>算术运算符</h3>
<table border="1">
	<tr><td>\${17+5}</td><td>${17+5 }</td></tr>
	<tr><td>\${17-5}</td><td>${17-5 }</td></tr>
	<tr><td>\${17* 5}</td><td>${17*5 }</td></tr>
	<tr><td>\${17 div 5}</td><td>${17/5 }</td></tr>
	<tr><td>\${17 mod 5}</td><td>${17 mod 5 }</td></tr>
	
</table>

<h3>关系运算符</h3>

<table border="1">
	<tr><td>\${5==5}</td><td>${5==5}</td></tr>
	<tr><td>\${5!=5}</td><td>${5!=5}</td></tr>
	<tr><td>\${5>5}</td><td>${5>5}</td></tr>
	<tr><td>\${5 >= 5}</td><td>${5>=5}</td></tr>
	<tr><td>\${5 < 5}</td><td>${5<5}</td></tr>
	<tr><td>\${5 <= 5}</td><td>${5<=5}</td></tr>
	
</table>
<h3>逻辑运算符</h3>

<table border="1">
	<tr><td>\${true && true}</td><td>${true && true}</td></tr>
	<tr><td>\${true||false}</td><td>${true||false}</td></tr>
	<tr><td>\${!false}</td><td>${!false}</td></tr>
</table>

<%!String name=null;%>
${empty name}

${7>5 ? 7:5}


</body>
</html>