package junit_test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import action.ControlAction;



import util.ConnectToSQL;
import util.User;

public class TestConnect {

	@Before
	public void before(){
		System.out.println("before");
	}
	
	//这样的话就会抛出test timeout exception
    @Test(timeout = 1)     
    public void testTimeout() {    
    	long count = 1;
    	for(long i = 1;i<10000000000000l;i++){
        count++;
    	}
        System.out.println(count);
    } 

	//限时设置 超过时间终止

	//查看英文文档所学
	@Test
	public void test() {
		assertTrue(1==1);
		assertEquals(1,1);// 1 其实可以使有返回值得方法
		Connection con = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(con);
		ResultSet rs = null;
		try {
			System.out.println(st.execute("select count(*) from user"));
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs = st.executeQuery("select count(*) from user");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertNotNull(ConnectToSQL.getConn());
		try {
			rs.next();
			assertEquals(4,rs.getInt(1));
			System.out.println(rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "";
		try {
			rs = st.executeQuery("select * from user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				try {
					s+= rs.getInt("userid")+rs.getString("username")+rs.getInt("password");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
		System.out.println("sdfsdf");
	}
	@Test
	public void test2() {
		Connection con = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(con);
		ResultSet rs = null;
		try {
			st.executeUpdate("insert into `user` (`userid`, `username`, `password`) values(null,'sdfy','123')");
			st.execute("insert into `user` (`userid`, `username`, `password`) values(null,'sdfy','123')");
			st.execute("select * from user");
			rs = st.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			System.out.println("------------");
			System.out.println(column);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
	@After
	public void dter(){
		System.out.println("after");
	}
	
	@Test
	public void testList(){
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		List<User> list = new ArrayList<User>();
		try {
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("userid"));
				u.setName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> o  = JSONArray.fromObject(list);
		System.out.println(o.toString());
		//System.out.println(list.toString());
	}

}
