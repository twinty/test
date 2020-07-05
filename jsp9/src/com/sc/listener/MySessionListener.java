package com.sc.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	
	public static int count=0;//����������

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		System.out.println("ĳ�û�������վ�ˣ�"+count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		System.out.println("ĳ�û��Ƴ���վ�ˣ�"+count);
	}

}
