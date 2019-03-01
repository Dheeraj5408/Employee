<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Details</title>
<style type="text/css">
h1{
color: grey;
}
a{
font-size: 20px;
}
label{
font-size : 15px;
}
</style>
</head>
<body>
<li><a href="Home.jsp">Home</a></li>
<pre>
<form action="ControllerServletUpdateEmployee" method="post">
<br><br><br><br>
<center><h1>Update Details</h1></center>
<center><label>Employee Id     : </label><input type="number" name="id" placeholder="Enter Id" title="only numbers allowed no alphabets no special characters" width="50" required="required"></center>

<center><label>Employee Name   : </label><input type="text" name="name" placeholder="Enter Name" pattern="[A-Za-z ]+" title="only alphabets allowed" width="50" required="required" ></center>

<center><label>Employee Salary : </label><input type="number" name="salary" placeholder="Enter Salary" title="only numbers allowed no alphabets no special characters" width="50" required="required"> </center>

<center><button type="submit">Update</button></center>

</form>
<center><img src="images/Employee-Management-System_img.jpg" width=20%/></center>
</pre>
</body>
</html>