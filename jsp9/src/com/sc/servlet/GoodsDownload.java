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
	
	//为什么这个地方不要utf-8????????????
	//获得图片路径的参数值
	String name=req.getParameter("name");//例如 upload/1.jpg
	
	//下载图片
	
	//1.创建smartupload对象
	//实例化组件对象才能使用jspsmrtupload.jar的功能
	SmartUpload su=new SmartUpload();
	
	//2.组件初始化
	//将req和resp处理得能接收和响应表单enctype="multipart/form-data"封装的信息
	su.initialize(getServletConfig(), req, resp);
	
	//3.设置浏览器不直接打开图片，而是弹出下载对话框，下载图片
	su.setContentDisposition(null);
	//4.下载文件
	try {
		su.downloadFile(name);
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("文件下载失败！");
	}


}
}
