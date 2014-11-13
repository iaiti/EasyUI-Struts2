<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="util.*"%>
<%@ page import="java.sql.*"%>
<%!
	Connection c = null;
	Statement st = null;
	String id = "";
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	id = request.getParameter("id");
   // System.out.println(id);
	c = ConnectToSQL.getConn();
	st = ConnectToSQL.getSt(c);
	
 	try{
	st.executeUpdate("delete from user where userid in ("+id+")");
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	response.sendRedirect("delete"); 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ConnectToSQL.close(c);
	ConnectToSQL.close(st);
%>
</body>
</html>