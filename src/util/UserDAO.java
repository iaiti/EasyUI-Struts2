package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	// add user
	public static void adduser(String name, String password) {
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		try {
			st.executeUpdate("insert into `user` (`userid`, `username`, `password`) values(null,'"
					+ name + "','" + password + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectToSQL.close(c);
		ConnectToSQL.close(st);
	}

	// delete user
	public static void deleteuser(String id) {
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		try {
			st.executeUpdate("delete from user where userid in (" + id + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectToSQL.close(c);
		ConnectToSQL.close(st);
	}
	
	//update user
	public static void updateuser(String name,String password,String id){
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		try{
			st.executeUpdate("update user set username ='"+name+"',password ='"+password+"' where userid ="+id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		ConnectToSQL.close(c);
		ConnectToSQL.close(st);
	}
	
	public static String deletestring(){
		String s = "";
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		ResultSet rs = ConnectToSQL.getRs(c, st);
		try {
			while(rs.next()){
				s+= rs.getInt("userid")+"  "+rs.getString("username")+
				"   <a href='deleteuser?id="+rs.getInt("userid")+"'>删除</a><br/>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectToSQL.close(c);
		ConnectToSQL.close(st);
		ConnectToSQL.close(rs);
		return s;
	}
	
	public static String updatestring(){
		String s = "";
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		ResultSet rs = ConnectToSQL.getRs(c, st);
		try {
			while(rs.next()){
				s+= rs.getInt("userid")+"  "+rs.getString("username")+"  "+
				rs.getString("password")+"   <a href='updateuser?id="+rs.getInt("userid")+"'>更新"+
				"</a><br/>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectToSQL.close(c);
		ConnectToSQL.close(st);
		ConnectToSQL.close(rs);
		return s;
	}
}
