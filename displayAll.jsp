<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Products List</h1>
<br>
<table border="2">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Category</th>
	<th>Price</th>
	<th>Quantity</th>
</tr>
<c:forEach items="${listed}" var="li">
<tr>
	<td>${li.id}</td>
	<td>${li.name}</td>
	<td>${li.category}</td>
	<td>${li.price}</td>
	<td>${li.quantity}</td>

</tr>








</c:forEach>



</table>
<a href="index.jsp">GO Back</a>
</body>
</html>