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

@WebServlet("/CarAdd") //�����ַ
public class CarAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���������ַ�����
		req.setCharacterEncoding("utf-8");
		//ͬ����Ĳ������ƻ�ȡ����Ĳ���ֵ
		String gidStr=req.getParameter("gid");
		String gname=req.getParameter("gname");
		String gpriceStr=req.getParameter("gprice");
		String gimg=req.getParameter("gimg");
		String gnumStr=req.getParameter("gnum");
		
		//����ת��
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int gnum=Integer.parseInt(gnumStr);
		//�ѱ�����װ����Ʒ����
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, 0);
		
		//ͨ����������ȡsession����
		HttpSession session=req.getSession();
		//��session��ȡ����ǰ��½���û�����
		Users nowu=(Users)session.getAttribute("nowuser");
		int uid=nowu.getUid();//��ǰ��½���û�id
		
		//��bug���ڲ���֮ǰ������û�uid����Ʒgid�жϹ��ﳵ���Ƿ�����ͬ����
		//����еĻ�����ô�޸ĸ������ݵ�gnum��ֵ���ۼ�+1
		//���û�еĻ�����ôִ���������Ӳ���
		
		//����dao��ɶ���Ʒ���浽���ﳵ��Ĳ���
		CarDao dao=new CarDao();
		dao.add(g, uid);
		
		//����Ҫ��ѯ�����û����еĹ��ﳵ��Ʒ����ҳ������ʾ
		List<Cars> list = dao.select(uid);
		
		//�Ѽ��ϴ���session����
		session.setAttribute("mycars", list);
        //�ض��򵽹��ﳵҳ��
		resp.sendRedirect("car.jsp");
	}
	
}
