<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
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
<h1>${dojo.name} Ninjas</h1>
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
     
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="ninja" items="${dojo.ninjas}">
    <tr>
      <td><c:out value="${ninja.firstName}"/></td>
      <td><c:out value="${ninja.lastName}"/></td>
      <td><c:out value="${ninja.age}"/></td>
      
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
</body>
</html>