<%@page import="com.sc.bean.Cars"%>
<%@page import="com.sc.bean.Users"%>
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
    
    <title>My JSP 'car.jsp' starting page</title>
    
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
        <%--   <%
       Users nowu=(Users)session.getAttribute("nowuser");
       %> --%>
       <%--  <%=nowu.getUname() %> --%>
       
       ${sessionScope.nowuser.uname}
      
                       的购物车
       </h1>
       <h2>
         <a href="goods.jsp">继续购物</a>
       </h2>
       
       <table border="1" width="80%" style="text-align: center;">
          <tr>
             <th>商品编号</th>
             <th>商品图片</th>
             <th>商品名称</th>
             <th>购买数量</th>
             <th>商品单价</th>
             <th>商品价格</th>
             <th>操作</th>
          </tr> 
                  
           <c:forEach items="${sessionScope.mycars }" var="c">
           <tr>
                  <td>
                    
                      ${c.gid }
                  </td>
                  <td>
                     <img src="${param.gimg }" width="88px" height="88px">
                  </td>
                  <td>
                     
                     ${c.gname }
                  </td>
                  <td>
                     
                     ${c.gnum }
                  </td>
                  <td>
                    
                     ${c.gprice }
                  </td>
                  <td>
                    
                     ${c.gnum * c.gprice }
                  </td>
                  <td>
                  </td>
               </tr>
           </c:forEach>
           
            <%--  <%
            ArrayList<Cars> list= (ArrayList<Cars>)session.getAttribute("mycars");
            for(int i=0;i<list.size();i++){
               Cars c=list.get(i);
           %> --%>
               <%-- <tr>
                  <td>
                     <%=c.getGid() %>
                      -${param.gid }
                  </td>
                  <td>
                     <img src="<%=c.getGimg() %>" width="88px" height="88px">
                  </td>
                  <td>
                     <%=c.getGname() %>
                     -${param.gname }
                  </td>
                  <td>
                     <%=c.getGnum() %>
                     -${param.gnum }
                  </td>
                  <td>
                     <%=c.getGprice() %>
                     -${param.gprice }
                  </td>
                  <td>
                     <%=c.getGnum()*c.getGprice() %>
                     -${param.gnum * param.gprice }
                  </td>
                  <td>
                  </td>
               </tr> --%>
         <%--  <%} %> --%>
       </table>
    </center>
    
  </body>
</html>
