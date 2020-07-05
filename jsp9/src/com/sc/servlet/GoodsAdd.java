package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsAdd")
public class GoodsAdd extends HttpServlet {
	
	@Override			//ע��������dopost����
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ʹ��jspsmartupload����ϴ�ͼƬ
		
		//1.����smartupload����.
		//ʵ��������������ʹ��jspsmartupload.jar�Ĺ���
		SmartUpload su=new SmartUpload();
		
		//2.�����ʼ��
		su.initialize(super.getServletConfig(), req, resp);
		 //��req��resp������ܽ��պ���Ӧ��enctype="multipart/form-data"��װ����Ϣ
	    //su.initialize(getServletConfig(), req, resp);
		
		//3.����������ļ����ͣ���ʡ�������ִ�Сд.jpg   .gif  .bmpͼƬ�ļ�����չ��
		su.setAllowedFilesList("jpg,gif,bmp,png,JPG,GIF,PNG,BMP");

		String gimg=null;//��ƷͼƬ����
		
		
		try {
			//4.��ҳ�洫�������ļ��ϴ���������
			su.upload();
			
			//5.����ļ�����
			//getFiles()��ȡ��jspҳ������file�ؼ��������ļ���getFile(0)ȡ�õ�һ���ؼ����ļ�
			File file = su.getFiles().getFile(0);//���᷵��һ���ļ�
			
			//6.�ж��û��Ƿ�ѡ���ļ���
			if(file.isMissing()){//�û�ûѡ�ļ�
				//����û�û������ѡ���ļ�����Ҫ����ԭʼ�ļ�
				gimg=su.getRequest().getParameter("gimg");
			}else{//�û�ѡ���ļ�
				//�ȴ���upload�ļ������ڱ����ϴ�������ͼƬ������ȡ�������е�����·��
				String path=req.getServletContext().getRealPath("upload");
				System.out.println("����·���ǣ�"+path);
				String name=path+"/"+file.getFileName();//���ҵ�б��Ҫ�����������б��Ҫһ��
				System.out.println("������ַ�ǣ�"+name);
				//7.����ļ�����Ҫ���浽·��
				file.saveAs(name);
				gimg=file.getFileName();//���ļ����Ƹ�gimg���浽���У����ļ����ƴ������ݿ�
			}
			
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ��ϴ�ʧ�ܣ�");
		}
		
		
		//���������ַ�����
		req.setCharacterEncoding("utf-8");
		//��ȡ���������Ĳ���ֵ
		//������ϴ��ļ�����ô��ǰ��req�����ȡ����Ȣ����ֵ�ˡ�
		//����ͨ��smartup
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		
		//����ת��
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		
        //������Ʒ��ϢҲ����ֵ
		int gnum=1;//Ĭ��Ϊ1��
		int gid=0;//���һ��ֵ������Ҫ��
	
		
		//��װ�ɶ���
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		
        //����dao�����Ʒ���
		GoodsDao dao=new GoodsDao();
		dao.add(g);
		
		//������ɺ��ض���goodselect��
		resp.sendRedirect("GoodsSelect");
	}

}
