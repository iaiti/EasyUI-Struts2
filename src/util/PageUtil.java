package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PageUtil {
	public static String getPage(int pagenumber,int rows){
		String result = "";
		int count = 0;
		int number = 0;
		Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		List<User> list = new ArrayList<User>();
		try {
			ResultSet countrs = st.executeQuery("select count(*) from user");
			countrs.next();
			//
			//System.out.println(countrs.getInt(1));
			count = countrs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(count%rows==0){
			number =count/rows;
		}else{
			number = count/rows+1;
		}
		//
		//System.out.println(number);
		try {
			int index = 0;
			if(pagenumber-1>0){
				index = (pagenumber-1)*rows-1;
			}
			ResultSet rs = st.executeQuery("select * from user limit "+index+","+rows);
			
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("userid"));
				u.setName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//这个把list看成数组，用json格式输出   只是输出list
		List<User> o  = JSONArray.fromObject(list);
		
		
		//无需字符串拼接
		//String result = "{\"total\":"+count+",\"rows\":"+s+"}";
		
		//接下来的是吧整个对象转json格式  对象有两个属性 total和rows属性  而rows里面又是一个数组 
		JSONObject jo = new JSONObject();
		jo.put("total", count);
		jo.put("rows", list);
		result = jo.toString();
		return result;
	}
	public static void main(String[] args) {
		//pagenumber  rows
		String s = PageUtil.getPage(10, 3);
		//
		//System.out.println(s);
		
	}
}
