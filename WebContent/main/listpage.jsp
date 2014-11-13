<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="util.*"%>
<%@ page import="java.sql.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<script src="<%=basePath%>jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>jquery.easyui.min.js" type="text/javascript"></script>
<link href="<%=basePath%>themes/default/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>themes/icon.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script language="JavaScript">
	function newUser() {
		$('#dlg').dialog('open').dialog('setTitle', '新建用户');
		$('#fm').form('clear');
	}

	function saveUser() {
		$('#fm').form('submit', {
			url : "adduser",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			}
		});
	}
	function editUser() {
		var row = $('#dg').datagrid('getSelections');
		if (row.length == 0) {
			alert("请选择要编辑的行");
		} else if (row.length > 1) {
			alert("你只能编辑一行");
		} else {
			$('#passwordinput').attr("value", row[0].password);
			$('#nameinput').attr("value", row[0].name);
			$('#dlg2').dialog('open').dialog('setTitle', '编辑用户');
			//alert(row.name);
			//alert(JSON.stringify(row[0]));
		}
	}

	function updateUser() {
		var row = $('#dg').datagrid('getSelected');

		$('#fm2').form('submit', {
			url : 'updateuser_successful?id=' + row.id,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				$('#dlg2').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			}
		});
	}

	function destroyUser() {
		// 返回被选中的行 然后集成的其实是 对象数组
		var row = $('#dg').datagrid('getSelections');
		var i = 0;
		var string = "";
		for (i; i < row.length; i++) {
			string += row[i].id;
			if (i < row.length - 1) {
				string += ',';
			} else {
				break;
			}
		}
		//alert(string);
		//var row = $('#dg').datagrid('getSelected');
		//alert(row.id);
		if (row.length == 0) {
			alert("请选择要删除的行");
		}
		if (row.length > 0) {
			$.messager.confirm('Confirm', '确定删除用户?', function(r) {
				if (r) {
					$.post('deleteuser', {
						id : string
					}, function(result) {
						$('#dg').datagrid('reload');
					});
				}
			});
		}
	}
</script>
</head>
<body>

	<div id="content" class="easyui-panel" style="height: 200px"
		data-options="href:'list_ej'"></div>
	<div class="easyui-pagination" style="border: 1px solid #ccc;"
		data-options=" 
	total: 2000, 
	pageSize: 10, 
	onSelectPage: function(pageNumber, pageSize){ 
	$('#content').panel('refresh', 'show_content.php?page='+pageNumber); 
	}">
	</div>
	<table id="dg" title="My Users" class="easyui-datagrid"
		style="width: 700px; height: 500px" url="list_ej" toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="false"
		checkbox="true">
		<thead>
			<tr>
				<!-- 			<th field="id" width="50">id</th>
			<th field="name" width="50">name</th>
			<th field="password" width="50">password</th> -->

				<!-- 		这种写法也是可以的	    <th data-options="field:'id',width:150">id</th> -->

				<th field="ck" checkbox="true"></th>
				<th data-options="field:'id',width:'200px'">id</th>
				<th data-options="field:'name',width:'200px'">name</th>
				<th data-options="field:'password',width:'200px',align:'right'">password</th>
			</tr>
		</thead>
	</table>
	<div id="pp" class="easyui-pagination"
		data-options="total:200,pageSize:10"
		style="background: #efefef; border: 1px solid #ccc;"></div>

	<!--  新建对话框 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>name:</label> <input name="user" class="easyui-validatebox"
					required="true" missingMessage="name不能为空">
			</div>
			<div class="fitem">
				<label>password:</label> <input name="pwd"
					class="easyui-validatebox" required="true"
					missingMessage="password不能为空">
			</div>

		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>

	<!--  编辑对话框 -->
	<div id="dlg2" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">编辑数据</div>
		<form id="fm2" method="post">
			<div class="fitem">
				<label>name:</label> <input name="user" id="nameinput"
					class="easyui-validatebox" required="true"
					missingMessage="name不能为空">
			</div>
			<div class="fitem">
				<label>password:</label> <input name="pwd" id="passwordinput"
					class="easyui-validatebox" required="true"
					missingMessage="password不能为空">
			</div>

		</form>
	</div>
	<div id="dlg-buttons">
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateUser()">提交</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>

	<!--  工具栏 -->
	<div id="toolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">新建用户</a> <a class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a> <a
			class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyUser()">删除用户</a>
	</div>

</body>
</html>