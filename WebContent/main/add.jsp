<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>checkpw.js"></script>
</head>
<body>
<form action="adduser" name="form" method="post" onsubmit="return password()">
<table width="750" align="center" border="2">
			<tr>
				<td>用户名</td>
				<td><input type="text" size="30" id="user" name="user" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" size="30" id="pwd" name="pwd" /></td>
			</tr>
			<tr>
				<td>密码确认</td>
				<td><input type=password name="pwd2" id="pwd2" size="30" >
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"> 
				<input type="reset" value="重置"> </td>
			</tr>
		</table>

</form>
</body>
</html>