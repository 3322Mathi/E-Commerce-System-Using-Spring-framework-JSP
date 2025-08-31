<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" modelAttribute="product">

<form:label path="name">Product Name</form:label>
<form:input path="name"/>
<br><br>
<form:label path="category">Product category</form:label>
<form:input path="category"/>
<br><br>
<form:label path="price">Product price</form:label>
<form:input path="price"/>
<br><br>
<form:label path="quantity">Product quantity</form:label>
<form:input path="quantity"/>
<br><br>
<input type="submit" value="add a product">

</form:form>
</body>
</html>