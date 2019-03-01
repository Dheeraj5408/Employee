<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Your Project</title>
<style type="text/css">
h1{
color :grey;
}
label{
font-size : 20px;
}
a{
font-size: 20px;
}
</style>
</head>
<body>
<li><a href="Home.jsp">Home</a></li>
<pre>
<form action="ControllerServletAddProject" method="post">
<center><h1>Add Project</h1></center>
<center><label>Project Name : </label><input type="text" name="projectname" placeholder="Project name" pattern="[A-Za-z0-9 ]+" title="alphanumeric allowed no special character" widht="50" required="required"></center>

<center><label>Assign To    : </label><input type="number" name="id" placeholder="Employee Id" width="50" required="required"></center>

<center><button type="submit">ADD</button></center>
</form>
<center><img src="images/Employee-Management-System_img.jpg" width=20%/></center>
</pre>
</body>
</html>