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
		//使用jspsmartupload组件上窜图片
		
				//1.创建smartupload对象.
				//实例化组件对象才能使用jspsmartupload.jar的功能
				SmartUpload su=new SmartUpload();
				
				//2.组件初始化
				su.initialize(super.getServletConfig(), req, resp);
				 //将req和resp处理得能接收和响应表单enctype="multipart/form-data"封装的信息
			    //su.initialize(getServletConfig(), req, resp);
				
				//3.设置允许的文件类型（可省）会区分大小写.jpg   .gif  .bmp图片文件的扩展名
				su.setAllowedFilesList("jpg,gif,bmp,png,JPG,GIF,PNG,BMP");

				String gimg=null;//商品图片名称
				
				
				try {
					//4.把页面传过来的文件上传到服务器
					su.upload();
					
					//5.获得文件对象
					//getFiles()获取到jsp页面所有file控件传来的文件；getFile(0)取得第一个控件的文件
					File file = su.getFiles().getFile(0);//它会返回一个文件
					
					//6.判断用户是否选择文件了
					if(file.isMissing()){//用户没选文件
						//如果用户没有重新选择文件，还要保存原始文件，服务器里面有
						gimg=su.getRequest().getParameter("gimg");
					}else{//用户选择文件
						//先创建upload文件夹用于保存上传的搜有图片，并获取服务器中的完整路径
						String path=req.getServletContext().getRealPath("upload");
						System.out.println("保存路径是："+path);
						String name=path+"/"+file.getFileName();//向右的斜杠要两个，向左的斜杠要一个
						System.out.println("完整地址是："+name);
						//7.另存文件到需要保存到路径
						file.saveAs(name);
						gimg=file.getFileName();//把文件名称给gimg保存到表中，把文件名称存入数据库
					}
					
					
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件上传失败！");
				}
				
		
		
		//设置请求字符编码
		req.setCharacterEncoding("utf-8");
		//获取表单传过来的参数值
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		String gnumStr=su.getRequest().getParameter("gnum");
		String gidStr=su.getRequest().getParameter("gid");
		//String gimg=su.getRequest().getParameter("gimg"); 前面已经定义好了
		
		//类型转换
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		int gnum=Integer.parseInt(gnumStr);
		int gid=Integer.parseInt(gidStr);
		
		//封装成对象
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		
        //调用dao完成修改添加
		GoodsDao dao=new GoodsDao();
		dao.update(g);
		
		//操作完成后，重定向到goodselect类
		resp.sendRedirect("GoodsSelect");
	}

}
