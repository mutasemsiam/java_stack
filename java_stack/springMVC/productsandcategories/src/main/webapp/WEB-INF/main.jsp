<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
<h1 class="text-center">Home Page</h1>
<h6><a href="/products/new">New Product</a></h6>
<h6><a href="/categories/new">New Category</a></h6>

<div class="mytables d-flex">
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col" class="text-center">Products</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="product" items="${products}">
    <tr>
      <td class="text-center"><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
    </tr>
    </c:forEach>

  </tbody>
</table>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col" class="text-center">Categories</th>

    </tr>
  </thead>
  <tbody>
  	<c:forEach var="category" items="${categories}">
    <tr>
      <td class="text-center"><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></td> 
    </tr>
    </c:forEach>

  </tbody>
</table>
</div>


</div>

</body>
</html>