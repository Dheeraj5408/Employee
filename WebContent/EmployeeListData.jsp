<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="15;url=Home.jsp">
<title>Employee List Data</title>
</head>
<body>
<%@page import="com.psq.emsdao.*,com.psqit.ems.emspojo.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
        var="myDS"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/employees"
        user="root" password="root"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
       select employees.id , employees.name , salary.salary from employees INNER JOIN salary ON employees.id = salary.id;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
               
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.salary}</td>
                   
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>