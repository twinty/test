package com.sc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Cars;
import com.sc.bean.Goods;

public class CarDao {
	
	ConnDB db=new ConnDB();
	
	//添加购物车表的信息 
	public void add(Goods g,int uid){
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，调用执行方法，添加数据
		String sql="insert into cars values(null,"+g.getGid()+",'"+g.getGname()+"',"+
		            g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()+","+uid+")";
		System.out.println("执行是sql语句字符串："+sql);
		db.execute(sql);
		//3、关闭资源
		db.close();
	}
	
	//查询某用户的购物车商品
	public List<Cars> select(int uid){
		List<Cars> list=new ArrayList<Cars>();
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，调用查询方法，查询数据
		String sql="select * from cars where uid="+uid;
		ResultSet rs = db.select(sql);
		//3、处理结果集
		try {
			while(rs!=null&&rs.next()){
				//把每行的所有列的值取出封装成cars对象
				Cars c=new Cars(rs.getInt("cid"), 
						rs.getInt("gid"), 
						rs.getString("gname"), 
						rs.getFloat("gprice"), 
						rs.getString("gimg"), 
						rs.getInt("gnum"), 
						rs.getInt("uid"));
				//把cars对象存入集合
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询用户的购物车商品失败！");
		}
		//4、关闭资源
		db.close();
		
		return list;
	}

}
