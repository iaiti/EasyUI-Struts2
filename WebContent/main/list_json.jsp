
<%
//only return string in json and the datagrid will show all the data
String json=(String)request.getAttribute("json");
//System.out.println(json);
%>

<%=json%>
