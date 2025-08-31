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
<table border="2">
<tr>
<th>Id</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<th>Total Price</th>

</tr>
<c:forEach items="${listed}" var="li">
<tr>
<td>${li.id}</td>
<td>${li.name}</td>
<td>${li.category}</td>
<td>${li.price}</td>
<td>${li.newQuantity}</td>
<td>${li.totalPrice}</td>
</tr>
</c:forEach>

</table>
<h2>Purchased Successfully</h2>
<a href="index.jsp">GO Back</a>

</body>
</html>