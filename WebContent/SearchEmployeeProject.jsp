<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee Project</title>
<style type="text/css">
label{
font-size : 15px;
}
h1{
color : grey;
}
a{
font-size: 20px;
}
</style>
</head>
<body>
<li><a href="Home.jsp">Home</a></li>
<form action="ControllerServletSearchEmployeeProject" method="post">
<br><br><br><br><br>
<center><h1>Search Your Project</h1></center>
<center><label>Employee Id :</label><input type="number" name="id" placeholder="Enter Id" width="50" required="required"></center>
<br>
<center><button type="submit">Search</button></center>
</form>
<center><img src="images/Employee-Management-System_img.jpg" width=20%/></center>
</body>
</html>