<%@page import="com.sc.bean.Goods"%>
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
    
    <title>My JSP 'goodsselect.jsp' starting page</title>
    
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
       <h1>
                       商品列表
       </h1>
       <h2>
         <a href="goodsadd.jsp">添加商品</a>
       </h2>
       
       <table border="1" width="80%" style="text-align: center;">
          <tr>
             <th>商品编号</th>
             <th>商品图片</th>
             <th>商品名称</th>
             <th>购买数量</th>
             <th>商品单价</th>
             <th>库存数量</th>
             <th>操作</th>
          </tr> 
         
          <c:forEach items="${requestScope.goods }" var="g">
          <tr>
                  <td>
                     
                     ${g.gid }
                  </td>
                  
                  <td>
                  <a  href="GoodsDownload?name=upload/${g.gimg }">        
                     <img src="upload/${g.gimg }" width="88px" height="88px">
                  	<!-- upload文件夹路径 -->
                  </a>
                  </td>
                  <td>
                     ${g.gname }
                  </td>
                  <td>
                     ${g.gnum }
                  </td>
                  <td>
                     ${g.price }
                  </td>
                  <td>
                     ${g.gstock }
                  </td>
                  <td>
                      <a href="GoodsDelete?gid=${g.gid }">删除</a>
                      /
                      <a href="goodsupdate.jsp?gid=${g.gid }&gname=${g.gname }&gnum=${g.gnum }&gprice=${g.gprice }&gstock=${g.gstock }&gimg=${g.gid }">修改</a>
                  </td>
               </tr>
          </c:forEach>
          
        <%--   <%
            ArrayList<Goods> list= (ArrayList<Goods>)request.getAttribute("goods");
            for(int i=0;i<list.size();i++){
               Goods g=list.get(i);
           %>
              <tr>
                  <td>
                     <%=g.getGid() %>
                  </td>
                  
                  <td>
                  <a  href="GoodsDownload?name=upload/<%=g.getGimg() %>">        
                     <img src="upload/<%=g.getGimg() %>" width="88px" height="88px">
                  	<!-- upload文件夹路径 -->
                  </a>
                  </td>
                  <td>
                     <%=g.getGname() %>
                  </td>
                  <td>
                     <%=g.getGnum() %>
                  </td>
                  <td>
                     <%=g.getGprice() %>
                  </td>
                  <td>
                     <%=g.getGstock() %>
                  </td>
                  <td>
                      <a href="GoodsDelete?gid=<%=g.getGid() %>">删除</a>
                      /
                      <a href="goodsupdate.jsp?gid=<%=g.getGid() %>&gname=<%=g.getGname() %>&gnum=<%=g.getGnum() %>&gprice=<%=g.getGprice() %>&gstock=<%=g.getGstock() %>&gimg=<%=g.getGimg() %>">修改</a>
                  </td>
               </tr> 
          <%} %> --%>
       </table>
    </center>    

  </body>
</html>
