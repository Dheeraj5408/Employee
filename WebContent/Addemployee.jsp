<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Detail</title>
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
<pre>
<li><a href="Home.jsp">Home</a></li>
<form action="ControllerServlet" method="post"> 
<div >
<center><h1>Add Your Employee</h1></center>
<center><label>Employee Name    : </label><input type="text" name="Name" pattern="[A-Za-z ]+" title="only alphabets allowed" width="50" required="required"></center>

<center><label>Employee Salary  : </label><input type="number" name="Salary" width="50" title="only numbers allowed no alphabets no special character" required="required"></center>
</div>
<center><button type="Submit" >Add </button></center>
</form>
</pre>
<center><img src="images/Employee-Management-System_img.jpg" width=20%/></center>
</body>
</html>  