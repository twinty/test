package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/GoodsDownload")
public class GoodsDownload extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//Ϊʲô����ط���Ҫutf-8????????????
	//���ͼƬ·���Ĳ���ֵ
	String name=req.getParameter("name");//���� upload/1.jpg
	
	//����ͼƬ
	
	//1.����smartupload����
	//ʵ��������������ʹ��jspsmrtupload.jar�Ĺ���
	SmartUpload su=new SmartUpload();
	
	//2.�����ʼ��
	//��req��resp������ܽ��պ���Ӧ��enctype="multipart/form-data"��װ����Ϣ
	su.initialize(getServletConfig(), req, resp);
	
	//3.�����������ֱ�Ӵ�ͼƬ�����ǵ������ضԻ�������ͼƬ
	su.setContentDisposition(null);
	//4.�����ļ�
	try {
		su.downloadFile(name);
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("�ļ�����ʧ�ܣ�");
	}


}
}
