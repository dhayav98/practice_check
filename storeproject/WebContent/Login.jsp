<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.w3-display-topmiddle
{
width="400";
 height="200";

}

.button {
  background-color:#D3D3D3; 
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 20px 10px;
  cursor: pointer;
}
.button5 {border-radius: 50%;}
</style>
</head>
<body>
<center><div class=".w3-display-topmiddle">
<img src="login.jpg" alt="logo">
</div>
<form action="Login" method="post">
<h3>USER ID : </h3>
<input type="text" name="id">
<h3>PASSWORD : </h3>
<input type="password" name="pass">
<br>
<br>
<input class="button button5" type="submit" value="submit">
</form>
</center>

</body>
</html>