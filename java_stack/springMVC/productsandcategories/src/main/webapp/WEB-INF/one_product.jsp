<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1 class="text-center">${product.name}</h1>

<a href="/">Home</a>
<h2>Categories:</h2>
<ul>
<c:forEach var="category" items="${catgs}">
<li>${category.name}</li>
</c:forEach>
</ul>

<h2>Add Category:</h2>
<form action="/products/${product.id}" method="post">
    <p>	
    	<label>Category: </label>
        <select name="categoryId" id="categoryId">
        <c:forEach var="cat" items="${allRemainingCatgs}">
        	<option value="${cat.id}">${cat.name}</option>
        </c:forEach>
        </select> 
    </p>    
    <input type="submit" value="Submit"/>
</form>    
</div>

</body>
</html>