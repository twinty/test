package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.GoodsDao;

@WebServlet("/GoodsDelete")
public class GoodsDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取需要删除的商品编号
		String gidStr=req.getParameter("gid");
		int gid=Integer.parseInt(gidStr);
		
	    //调用dao，删除此商品
		GoodsDao dao=new GoodsDao();
		dao.delete(gid);
		
		//操作完成后，重定向到goodselect类
		resp.sendRedirect("GoodsSelect");
	}

}
