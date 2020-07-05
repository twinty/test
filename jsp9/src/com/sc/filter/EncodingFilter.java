package com.sc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {
	
	String encoding=null;//字符编码全局变量
	@Override
	public void destroy() {
		System.out.println("3.准备销毁过滤器");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("2.过滤请求或相应");
		//强转成HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)arg0;
		//设置请求对象的编码
		req.setCharacterEncoding(this.encoding);
		//	继续过滤
		arg2.doFilter(arg0,arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("1.初始化字符编码过滤器");
		//读取web.xml配置文件的encode初始化参数的值，例如：utf-8
		this.encoding=arg0.getInitParameter("encode");
	}

}
