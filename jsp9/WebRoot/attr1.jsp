<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'attr1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
  <%--   <%
    pageContext.setAttribute("name3", "lucy");//${pageScope.name3}
       //设置属性值
      request.setAttribute("name", "tom");
      request.setAttribute("age", 20);
      
      //request.removeAttribute("age");
      session.setAttribute("name1", "lily");
      application.setAttribute("name2", "jone");
     %> --%>
     
     <c:set var="name" value="tom1" scope="request"></c:set>
     <c:set var="age" value="20" scope="request"></c:set>
     <c:remove var="age" scope="request"/>
     
     <!-- 转发 -->
     <jsp:forward page="attr2.jsp?a=123">
       <jsp:param value="456" name="a"/>
     </jsp:forward>
     
  </body>
</html>
