<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>LayOut</title>
<script src="jquery.min.js"
	type="text/javascript"></script>
<script src="jquery.easyui.min.js"
	type="text/javascript"></script>
<link href="themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="themes/icon.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript">
	function addTab(title, url) {
		if ($('#home').tabs('exists', title)) {
			$('#home').tabs('select', title);
		} else {
			
			var content = '<iframe scrolling="auto" frameborder="0" src="'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#home').tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}

	$(document).ready(function() {

	});
</script>
<style>
.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}
</style>
</head>

<body class="easyui-layout">

	<div region="north" border="true" split="true"
		style="overflow: hidden; height: 80px;">
		<div class="footer">
			简单数据CRUD系统</a>
		</div>
	</div>

	<div region="south" border="true" split="true"
		style="overflow: hidden; height: 40px;">
		<div class="footer">
			版权所有：<a href="http://www.ewan.cn/">益玩平台</a>
		</div>
	</div>

	<div region="west" split="true" title="功能菜单" style="width: 200px;">

		<div id="aa" class="easyui-accordion"
			style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">

			<div title="查看数据" selected="true"
				style="overflow: auto; padding: 10px;">
				<ul class="easyui-tree">
					<li><a  onclick="addTab('用户列表','list')">用户玩家</a></li>
				</ul>
			</div>

			<div title="添加数据" style="padding: 10px;">
				<ul class="easyui-tree">

					<li><a href="#" onclick="addTab('添加用户','add')">添加用户</a></li>


				</ul>
			</div>

			<div title="删除数据" style="padding: 10px;">
				<ul class="easyui-tree">

					<li><a href="#" onclick="addTab('删除用户','delete')">删除用户</a></li>


				</ul>
			</div>
			<div title="修改数据" style="padding: 10px;">
				<ul class="easyui-tree">

					<li><a href="#" onclick="addTab('修改用户','update')">修改用户</a></li>


				</ul>
			</div>

		</div>
	</div>
	</div>
	
	

	<div id="mainPanle" region="center" style="overflow: hidden;">

		<div id="home" class="easyui-tabs" style="width: 1300px; height: 800px;">
			<div title="Home">Hello,welcome to use this system.</div>
		</div>
	</div>
</body>
</html>