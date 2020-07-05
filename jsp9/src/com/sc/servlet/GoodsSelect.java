package com.sc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsSelect")
public class GoodsSelect extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//����dao����ѯ������Ʒ��Ϣ
		GoodsDao dao=new GoodsDao();
		List<Goods> list = dao.select();
		
		//�Ѽ���װrequest����
		req.setAttribute("goods", list);
		//ת����jspҳ��
		req.getRequestDispatcher("goodsselect.jsp").forward(req, resp);
	}

}
