<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
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
<h1>New Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
       
    </p>
    
    <input type="submit" value="Create"/>
</form:form>    
</div>

</body>
</html>