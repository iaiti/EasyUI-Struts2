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

/**
 * @author ckc 2014-11-17 10:35:48
 * struts action
 */
public class ControlAction extends ActionSupport{
	private int rows;
	private int page;

	public String list_json(){
		
		ActionContext ctx=ActionContext.getContext();
		String result="";
		result= PageUtil.getPage(page, rows);
		try {
			//test2
			//Test
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
}
