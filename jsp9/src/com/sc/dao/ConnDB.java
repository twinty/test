package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class ConnDB {
	
	//开始实现代码重用
	Connection conn1 =null;
	Statement stat1 = null;
	ResultSet rs1 = null;
	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/db190506";
	String name="root";
	String pass="root";
	
	//第一步
	public void getConnDB(){
		//1、注册mysql数据库驱动类
		try {
			Class.forName(driver);
			System.out.println("注册驱动类成功");
		    conn1=DriverManager.getConnection(url, name, pass);
		    System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("注册驱动类失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
	//第二步：增删改
	public void execute(String sql){
		try {
			stat1 = conn1.createStatement();
			stat1.executeUpdate(sql);
			System.out.println("执行数据成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("执行数据库失败");
		}
	}
	
	//第二步：查询
	public ResultSet select(String sql){
		try {
			stat1 = conn1.createStatement();
			rs1 = stat1.executeQuery(sql);
			System.out.println("查詢数据库成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查詢数据库失败");
		}
		return rs1;
	}
	
	//第三步
	public void close(){
		try {
			if(rs1!=null&&!rs1.isClosed()){
				rs1.close();
			}
			if(stat1!=null&&!stat1.isClosed()){
				stat1.close();
			}
			if(conn1!=null&&!conn1.isClosed()){
			  conn1.close();
			}
			System.out.println("关闭所有资源成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("关闭所有资源失败");
		}
		
	}
	
}
