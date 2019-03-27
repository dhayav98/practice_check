<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

body {
  font-family: Arial;
  color: white;
}

.split {
  height: 100%;
  
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  left: 0;
  width: 40%;
  background-color:#505050;
  position: fixed;
}

.right {
  right:0;
  width: 60%;
  background-color: #C8C8C8;
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

.centered img {
  width: 150px;
  border-radius: 50%;
}
</style>
<script>
var req;
function update()
{
	//var number=document.form1.vehicleno.value;
	var url="DisplayDetails";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXobject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readystate==4)
				{
					var val=req.responseText;
					document.getElementByID("id1").innerHTML=val;
				}
		}
		req.open("GET",url,true);
		req.send();
	}
	catch(e)
	{
		alert("Unable to connect Server");
	}
}
</script>
</head>
<body >


<div class="split left">
  <div class="centered">
    <img src="img_avatar.png" alt="Avatar woman">
    <h2>Dhayanand</h2>
    <br>
    <h2>ID</h2>
    <h3>GRZLY765</h3>
    <br>
    <h2>DESIGNATION</h2>
    <h3>Sr.Admin</h3>
    <p></p>
  </div>
</div>
<div class="split right">
<h2 style="text-align:right;">
<b>Welcome: <%=session.getAttribute("name")%>
</b>
</h2>
<div class="centered">
  
<h2 style="text-align: center;"> Product </h2>
<form action="Home" method="post" style="text-align: center;">

Product Id:<br><input type="text" name="id"><br><br>
Product Name:<br><input type="text" name="name"><br><br>
Category:<br>
<select name="category" id="category">
<option value="Beverages">Beverages</option>
<option value="Bread/Bakery">Bread/Baker</option>
<option value="Dairy">Dairy</option>
<option value="Meat">Meat </option>
<option value="Paper Goods">Paper Goods</option> 
</select><br><br>
Description:<br><input type="text" name="desc"><br><br>
Price:<br><input type="text" name="price"><br><br>
<br><input type="submit" value="Add Product" name="enter1">
<input type="reset" value="Reset">

</form>
<br>
<br>
<form name="f1">
<input type="submit"  value="List Product" onclick="update()">
</form>
<span id="id1"></span>
</div>
</div>
</body>
</html>