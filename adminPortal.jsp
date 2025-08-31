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
background-color: olive;
}
a{
text-decoration: none;
color: white;
height: 40px;
width: 80px;
background-color: black;
border: 2px solid white;
}

</style>
<body>
<h1>${message}</h1>
<br><br>
<a href="insert">Add a Product</a>
<br><br>
<a href="find">Find a Product</a>
<br><br>
<a href="pdisplay">Display All</a>
<br><br>
<a href="increaseQuant">Increase Quantity</a>
<br><br>
<a href="delete">Delete a Product</a>
<br><br>
<a href="index.jsp">Go Back</a>
</body>
</html>