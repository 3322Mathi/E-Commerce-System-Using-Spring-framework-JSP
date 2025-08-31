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
<form action="viewPrice">

Enter the Product name and Check out the price : <input type="text" name="name"> 
<br> <br>
<input type="submit" value="view price"> 
<br> <br>
<p>Price is :  ${amount}</p>


</form>
 
<hr>
<br>
<form action="purchase">
Enter the product name : <input type="text" name="name">
<br> <br>
Enter the Quantity : <input type="number" name="newQuantity">
<br><br>

<input type="submit" value="Add to Cart">
<br><br>


</form>

<table border="2">
<tr>
<th>Id</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<th>Total Price</th>

</tr>
<c:forEach items="${cartList}" var="li">
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
<br><br>
 <button><a href="totalProduct" style=text-decoration:none;>Buy</a> </button>
</body>
</html>