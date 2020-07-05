package com.sc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Goods;

public class GoodsDao {
    ConnDB db=new ConnDB();
	
	public List<Goods> select(){
		List<Goods> list=new ArrayList<Goods>();
	   
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，查询数据库
		String sql="select * from goods";
		ResultSet rs = db.select(sql);
		//3、处理结果集
		try {
			while(rs!=null&&rs.next()){
				Goods g=new Goods(rs.getInt("gid"), 
						rs.getString("gname"), 
						rs.getFloat("gprice"), 
						rs.getString("gimg"), 
						rs.getInt("gnum"), 
						rs.getInt("gstock"));
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//4、关闭数据资源
		db.close();
		
		return list;
	}
	
	public void delete(int gid){
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，执行数据库
		String sql="delete from goods where gid="+gid;
		db.execute(sql);
		//3、关闭数据资源
		db.close();
	}
	
	public void add(Goods g){
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，执行数据库
		String sql="insert into goods values(null,'"+g.getGname()+"',"
		             +g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()
		             +","+g.getGstock()+")";
		System.out.println("添加sql是："+sql);
		db.execute(sql);
		//3、关闭数据资源
		db.close();
	}
	
	public void update(Goods g){
		//1、连接数据库
		db.getConnDB();
		//2、编写sql语句，执行数据库
		String sql="update  goods set gname='"+g.getGname()
		            +"',gprice="+g.getGprice()
		            +",gimg='"+g.getGimg()
		            +"',gnum="+g.getGnum()
		            +",gstock="+g.getGstock()
		            +" where gid="+g.getGid();
		System.out.println("修改sql是："+sql);
		db.execute(sql);
		//3、关闭数据资源
		db.close();
	}

}
