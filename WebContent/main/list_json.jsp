
<%
/* Connection c = ConnectToSQL.getConn();
Statement st = ConnectToSQL.getSt(c);
List<User> list = new ArrayList<User>();
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
List<User> o  = JSONArray.fromObject(list); */
String json=(String)request.getAttribute("json");
//System.out.println(json);
%>

<%=json%>
