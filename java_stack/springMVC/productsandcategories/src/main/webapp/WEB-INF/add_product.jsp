<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="container">
<h1 class="text-center">New Product</h1>

<a href="/">Home</a>
<form:form action="/products/new" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Name: </form:label>
        <form:input path="name"/>
        <br>
        <form:errors class="text-danger" path="name"/>
    </p>
    <p>
        <form:label path="description">Description: </form:label>
        <form:textarea path="description"/>
        <br>
        <form:errors class="text-danger" path="description"/>
    </p>
    <p>
        <form:label path="price">Price: </form:label>
        <form:input type="number" path="price"/>
        <br>
        <form:errors class="text-danger" path="price"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>    

</div>

</body>
</html>