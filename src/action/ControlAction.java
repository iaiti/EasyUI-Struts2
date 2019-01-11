package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import util.ConnectToSQL;
import util.PageUtil;
import util.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ControlAction extends ActionSupport{

	private int rows;
	private int page;
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String list(){
		return "success";
	}
	public String list_json(){

		//
		//System.out.println("rows"+rows);
		//System.out.println("page"+page);
		/*Connection c = ConnectToSQL.getConn();
		Statement st = ConnectToSQL.getSt(c);
		List<User> list = new ArrayList<User>();
		try {
			ResultSet countrs = st.executeQuery("select count(*) from user");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		
		List<User> o  = JSONArray.fromObject(list);*/
		//System.out.println(result);
		ActionContext ctx=ActionContext.getContext();
		String result="";
		result= PageUtil.getPage(page, rows);
		try {
//			ServletActionContext.getResponse().getWriter().println(JSONArray.fromObject(list));
			ctx.put("json", result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "success";
	}
	public String add(){
		return "success";
	}
	public String update(){
		return "success";
	}
	public String delete(){
		return "success";
	}
	public String adduser(){
		return "success";
	}
	public String deleteuser(){
		return "success";
	}
	public String updateuser(){
		return "success";
	}
	public String updateuser_successful(){
		return "success";
	}
}
