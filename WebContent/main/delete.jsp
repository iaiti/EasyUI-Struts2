<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="util.*"%>
<%@ page import="java.sql.*"%>
<%!
	Connection c = null;
	Statement st = null;
	ResultSet rs = null;
	String s = "";
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 
	c = ConnectToSQL.getConn();
	st = ConnectToSQL.getSt(c);
	rs = st.executeQuery("select * from user");
	while(rs.next()){
		s+= rs.getInt("userid")+"  "+rs.getString("username")+
		"   <a href='deleteuser?id="+rs.getInt("userid")+"'>删除</a><br/>";
	}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= s %>

<%
	ConnectToSQL.close(c);
	ConnectToSQL.close(st);
	ConnectToSQL.close(rs);
	s = "";
%>
</body>
</html>