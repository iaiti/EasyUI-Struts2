//javascript去空格函数 
	function LTrim(str){ //去掉字符串 的头空格
		var i;
		for(i=0;i<str.length; i++) {
			if(str.charAt(i)!=" ") break;
		}
		str = str.substring(i,str.length);
		return str;
	}
	function RTrim(str){
		var i;
		for(i=str.length-1;i>=0;i--){
			if(str.charAt(i)!=" "&&str.charAt(i)!=" ") break;
		}
		str = str.substring(0,i+1);
		return str;
	}
	function Trim(str){
	
		return LTrim(RTrim(str));
	
	}
function password(){
		var pwd,pwd2;
	if(Trim(document.form.user.value) == "") {
			alert("请输入用户名!");
			return false;
		}
	pwd=document.getElementById("pwd").value;
	pwd2=document.getElementById("pwd2").value;
	if(pwd.length<1){
		alert("密码必须大于1位，请重新输入！");
		return false;
	}
	if(!(pwd==pwd2 && pwd2!='')){
		alert("两次输入的密码不一致，请重新输入！");
		document.getElementById("pwd").value="";
		document.getElementById("pwd2").value="";
		return false;
	}
	if(document.form.usertype.value== 0) {
		alert("请选择类型!");
		return false;
	}
	return true;
}