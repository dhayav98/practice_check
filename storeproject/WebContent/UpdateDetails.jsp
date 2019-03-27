<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
 background-color: #C8C8C8;
}
</style>
</head>
<body>
<%
String id=request.getParameter("id");
%>
<form action="UpdateDetails" method="get">
<h2>Update Details</h2>
<b><i>
<br>PRODUCT ID:<br><input type="text"  value="<%out.println(id); %>" name="id" ><br>
<br>Select Updated category:<br><select name="category" id="category">
<option value="Beverages">Beverages</option>
<option value="Bread/Bakery">Bread/Baker</option>
<option value="Dairy">Dairy</option>
<option value="Meat">Meat </option>
<option value="Paper Goods">Paper Goods</option> 
</select><br>
<br>Enter Updated Name:<br><input type="text" name="name"><br>
<br>Enter Updated Description:<br><input type="text" name="desc"><br>
<br>Enter Updated Price:<br><input type="text" name="price"><br>
<br><input type="submit" value="Submit" name="enter1">
<input type="reset" value="Reset">

</i></b>
</form>
<br><a href='Home.jsp'><button>Home</button></a><br>
</body>
</html>