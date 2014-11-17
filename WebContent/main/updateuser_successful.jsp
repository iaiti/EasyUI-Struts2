<%@page import="util.ConnectToSQL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
	String name = "";
	String password = "";
	String id = "";
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>checkpw.js"></script>
</head>
<body>
<%
	name = request.getParameter("user");
	id = request.getParameter("id");
	password = request.getParameter("pwd");
	UserDAO.updateuser(name, password, id);
	response.sendRedirect("update");
	
%>
</body>
</html>