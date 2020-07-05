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
	   
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬��ѯ���ݿ�
		String sql="select * from goods";
		ResultSet rs = db.select(sql);
		//3����������
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
		//4���ر�������Դ
		db.close();
		
		return list;
	}
	
	public void delete(int gid){
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬ִ�����ݿ�
		String sql="delete from goods where gid="+gid;
		db.execute(sql);
		//3���ر�������Դ
		db.close();
	}
	
	public void add(Goods g){
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬ִ�����ݿ�
		String sql="insert into goods values(null,'"+g.getGname()+"',"
		             +g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()
		             +","+g.getGstock()+")";
		System.out.println("���sql�ǣ�"+sql);
		db.execute(sql);
		//3���ر�������Դ
		db.close();
	}
	
	public void update(Goods g){
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬ִ�����ݿ�
		String sql="update  goods set gname='"+g.getGname()
		            +"',gprice="+g.getGprice()
		            +",gimg='"+g.getGimg()
		            +"',gnum="+g.getGnum()
		            +",gstock="+g.getGstock()
		            +" where gid="+g.getGid();
		System.out.println("�޸�sql�ǣ�"+sql);
		db.execute(sql);
		//3���ر�������Դ
		db.close();
	}

}
