package com.sc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Cars;
import com.sc.bean.Goods;

public class CarDao {
	
	ConnDB db=new ConnDB();
	
	//��ӹ��ﳵ�����Ϣ 
	public void add(Goods g,int uid){
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬����ִ�з������������
		String sql="insert into cars values(null,"+g.getGid()+",'"+g.getGname()+"',"+
		            g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()+","+uid+")";
		System.out.println("ִ����sql����ַ�����"+sql);
		db.execute(sql);
		//3���ر���Դ
		db.close();
	}
	
	//��ѯĳ�û��Ĺ��ﳵ��Ʒ
	public List<Cars> select(int uid){
		List<Cars> list=new ArrayList<Cars>();
		//1���������ݿ�
		db.getConnDB();
		//2����дsql��䣬���ò�ѯ��������ѯ����
		String sql="select * from cars where uid="+uid;
		ResultSet rs = db.select(sql);
		//3����������
		try {
			while(rs!=null&&rs.next()){
				//��ÿ�е������е�ֵȡ����װ��cars����
				Cars c=new Cars(rs.getInt("cid"), 
						rs.getInt("gid"), 
						rs.getString("gname"), 
						rs.getFloat("gprice"), 
						rs.getString("gimg"), 
						rs.getInt("gnum"), 
						rs.getInt("uid"));
				//��cars������뼯��
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ѯ�û��Ĺ��ﳵ��Ʒʧ�ܣ�");
		}
		//4���ر���Դ
		db.close();
		
		return list;
	}

}
