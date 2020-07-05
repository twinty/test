package com.sc.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	
	public static int count=0;//计数器变量

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		System.out.println("某用户进入网站了："+count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		System.out.println("某用户推出网站了："+count);
	}

}
