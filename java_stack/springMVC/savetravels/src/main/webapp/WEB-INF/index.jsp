<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Expenses</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="mymain">
<h1>Save Travels</h1>
<div class="mycontainer">
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="expense" items="${allExpenses}">
    <tr>
      <td> <c:out value="${expense.name}"/></td>
      <td><c:out value="${expense.vendor}"/></td>
      <td> $<c:out value="${expense.amount}"/></td>
      
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
<h1>Add an expense:</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <br>
        <form:errors class="text-danger" path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:textarea path="vendor"/>
        <br>
        <form:errors class="text-danger" path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount"/>
        <br>
        <form:errors class="text-danger" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>   
        <form:input  path="description" />
        <br>
        <form:errors class="text-danger" path="description"/>  
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</div>

</body>
</html>