package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectToSQL {
	public static Connection getConn(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Driver d = new com.mysql.jdbc.Driver(); 这样也是可以的
			con = DriverManager.getConnection("jdbc:mysql://localhost/yiwan?user=root&password=root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Statement getSt(Connection con){
		Statement st = null;
		if(con != null){
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return st;
	}
	
	public static ResultSet getRs(Connection con,Statement st){
		ResultSet rs = null;
		if(con != null && st != null){
			try {
				rs = st.executeQuery("select * from user");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static void close(Connection c){
		if(c != null){
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c = null;
		}
	}
	public static void close(Statement st){
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = null;
		}
	}
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	public static void main(String[] args) {
		Connection con = ConnectToSQL.getConn();
		System.out.println(con == null);
		Statement st = ConnectToSQL.getSt(con);
		ResultSet rs = null;
			try {
				rs = st.executeQuery("select count(*) from user");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated catch block
			try {
				rs.next();
				System.out.println(rs.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
