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
<section class="d-flex justify-content-between">
<h1>Expense Details</h1>
<a href="/expenses">Go Back</a>
</section>
<h3>Expense Name: <c:out value="${myExpense.name}"></c:out> </h3>
<h3>Expense Description: <c:out value="${myExpense.description}"></c:out> </h3>
<h3>Vendor: <c:out value="${myExpense.vendor}"></c:out> </h3>
<h3>Amount spent: $<c:out value="${myExpense.amount}"></c:out> </h3>

</div>
</body>
</html>