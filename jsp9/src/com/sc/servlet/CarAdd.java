package com.sc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Cars;
import com.sc.bean.Goods;
import com.sc.bean.Users;
import com.sc.dao.CarDao;

@WebServlet("/CarAdd") //请求地址
public class CarAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求字符编码
		req.setCharacterEncoding("utf-8");
		//同请求的参数名称获取请求的参数值
		String gidStr=req.getParameter("gid");
		String gname=req.getParameter("gname");
		String gpriceStr=req.getParameter("gprice");
		String gimg=req.getParameter("gimg");
		String gnumStr=req.getParameter("gnum");
		
		//类型转换
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int gnum=Integer.parseInt(gnumStr);
		//把变量封装成商品对象
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, 0);
		
		//通过请求对象获取session对象
		HttpSession session=req.getSession();
		//从session中取出当前登陆的用户对象
		Users nowu=(Users)session.getAttribute("nowuser");
		int uid=nowu.getUid();//当前登陆的用户id
		
		//有bug：在插入之前，需过用户uid和商品gid判断购物车表是否有相同数据
		//如果有的话，那么修改该条数据的gnum的值，累加+1
		//如果没有的话，那么执行下面的添加操作
		
		//调用dao完成对商品保存到购物车表的操作
		CarDao dao=new CarDao();
		dao.add(g, uid);
		
		//还需要查询出该用户所有的购物车商品，在页面上显示
		List<Cars> list = dao.select(uid);
		
		//把集合存入session对象
		session.setAttribute("mycars", list);
        //重定向到购物车页面
		resp.sendRedirect("car.jsp");
	}
	
}
