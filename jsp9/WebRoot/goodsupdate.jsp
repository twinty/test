<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsadd.jsp' starting page</title>
    
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
    
    <center>
      <h1>商品修改</h1>
      <form action="GoodsUpdate" method="post" enctype="multipart/form-data">
            商品名称：<input type="text" name="gname" value="${param.gname }">
            <br>
            商品价格：<input type="text" name="gprice" value="${param.gprice }">
            <br>
            库存数量：<input type="text" name="gstock" value="${param.gstock }">
   			<br>
   			    <!-- 这是一个文件格式，不是gimg ；这里的name是input的名字；
            一方面把该文件提交上传到服务器，同时把该图片的名称保存到表中gimg列里面-->
   	商品图片：<input type="file" name="upload">		
            <br>
            <!-- 其他数据就使用隐藏域 -->				<!--<%=request.getParameter("gid")%>  -->
           
<!--
${param.name} 等价于 request.getParamter("name")，这两种方法一般用于服务器从页面或者客户端获取的内容。

${requestScope.name} 等价于 request.getAttribute("name")，一般是从服务器传递结果到页面，在页面中取出服务器保存的值。
  -->
            <input type="hidden" name="gid" value="${param.gid }">
            <input type="hidden" name="gimg" value="${param.gimg }">
            <input type="hidden" name="gnum" value="${param.gnum }">
            <input type="submit" value="提交">
      </form>
    </center>
    
  </body>
</html>
