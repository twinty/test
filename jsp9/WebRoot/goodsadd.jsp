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
      <h1>商品添加</h1>
      	<!--注意表单post的提交方法，不然获取不到图片  注意一下一定要叫后面这句话 enctype="multipart/form-data"-->
      <form action="GoodsAdd" method="post" enctype="multipart/form-data">
            商品名称：<input type="text" name="gname">
            <br>
            商品价格：<input type="text" name="gprice">
            <br>
            库存数量：<input type="text" name="gstock">
            <br>
            <!-- 这是一个文件格式，不是gimg ；这里的name是input的名字；
            一方面把该文件提交上传到服务器，同时把该图片的名称保存到表中gimg列里面-->
           商品图片：<input type="file" name="upload">
            <input type="submit" value="提交">
      </form>
    </center>
    
  </body>
</html>
