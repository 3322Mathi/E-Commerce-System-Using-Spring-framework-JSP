<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

body{
background-color: violet;
}
a{
text-decoration: none;
color: white;
height: 40px;
width: 80px;
background-color: black;
border: 2px solid white;
padding: 10px;
margin: 10px;
}
h1{
color: black;

}
</style>
<body>
<h1>Welcome Admin</h1>
<form action="gotit">
User Name : <input type="text" name="userName">
<br><br>
Password : <input type="number" name="password">
<br><br>
<input type="submit" value="Log in">

</form>
<br><br>
<a href="index.jsp"> GO Back</a>
</body>
</html>