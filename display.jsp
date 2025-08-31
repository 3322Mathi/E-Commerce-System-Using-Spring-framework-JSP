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
 </tr>
 
 <c:forEach items="${listed}" var="list">
 <tr>
    <td>${list.id}</td>
    <td>${list.name}</td>
    <td>${list.category}</td>
    <td>${list.price}</td>
    <td>${list.quantity}</td>
   </tr>
 
 
 </c:forEach>




</table>

<a href="index.jsp">Go Back</a>
</body>
</html>