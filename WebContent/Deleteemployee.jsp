<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1{
color : grey;
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
<form action="ControllerServletDeleteEmployee" method="post">
<center>
<h1>Enter Id of Employee To Whom You Want To Delete</h1>
<label>Employee Id :</label><input type="number" name="id" placeholder="Enter Id"width="50" required="required">


<button type ="submit">Delete</button>
</center>
</form>
<center><img src="images/Employee-Management-System_img.jpg" width=20%/></center>
</pre>
</body>
</html>