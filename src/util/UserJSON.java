
package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ckc
 *2014-11-13 10:17:01
 *不需要 一个单独的类来传json  只需要一个json类 将rows和total属性put进去即可
 */
//base分支提交
public class UserJSON {
	int total;
		List<User> list;
		//变基测试2
	public static void main(String[] args) {
		//变基测试
		String s = "";
		int count = 0;
		int number = 0;
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		List<User> users = new ArrayList<User>();
		try {
			ResultSet countrs = st.executeQuery("select count(*) from user");
			countrs.next();
			//
			System.out.println(countrs.getInt(1));
			count = countrs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			int index = 0;
			ResultSet rs = st.executeQuery("select * from user");
			
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("userid"));
				u.setName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//这个把list看成数组，用json格式输出
		List<User> o  = JSONArray.fromObject(users);
		System.out.println(o.toString());
		
		//接下来的是吧整个对象转json格式  对象有两个属性 total和rows属性  而rows里面又是一个数组 
		JSONObject jo = new JSONObject();
		jo.put("total", count);
		jo.put("rows", users);
		System.out.println(jo);
	}
	
}
