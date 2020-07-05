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

@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {
	
	@Override
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
						//����û�û������ѡ���ļ�����Ҫ����ԭʼ�ļ���������������
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
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		String gnumStr=su.getRequest().getParameter("gnum");
		String gidStr=su.getRequest().getParameter("gid");
		//String gimg=su.getRequest().getParameter("gimg"); ǰ���Ѿ��������
		
		//����ת��
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		int gnum=Integer.parseInt(gnumStr);
		int gid=Integer.parseInt(gidStr);
		
		//��װ�ɶ���
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		
        //����dao����޸����
		GoodsDao dao=new GoodsDao();
		dao.update(g);
		
		//������ɺ��ض���goodselect��
		resp.sendRedirect("GoodsSelect");
	}

}
