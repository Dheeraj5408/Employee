<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.psqit.ems.emspojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="15;url=Home.jsp">
<title>Employee Project Detail</title>
</head>
<body>
<center>
<br><br><br><br>
<%
ArrayList<Emspojo> viewEmployee = (ArrayList<Emspojo>)request.getAttribute("employeeprojectdata");
Emspojo p=null;
for(int i=0;i<viewEmployee.size();i++){
	p=viewEmployee.get(i);
	out.println("Employee Id    : "+p.getEmp_id()+"<br/><br/>");
	out.println("Project Name   : " +p.getProjectName()+"<br/><br/>");
}
%>
</center>

</body>
</html>