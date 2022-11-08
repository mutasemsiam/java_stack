<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
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
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    <p>	
    	<form:label path="dojo">Dojo: </form:label>
        <form:select path="dojo">
        <c:forEach var="dojo" items="${dojos}">
        	<option value="${dojo.id}">${dojo.name}</option>
        </c:forEach>
        </form:select>
        
    </p>
    <p>
        <form:label path="firstName">First Name: </form:label>
        <form:input type="text" path="firstName"/>
        <br>
        <form:errors class="text-danger" path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name: </form:label>
        <form:input type="text" path="lastName"/>
        <br>
        <form:errors class="text-danger" path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age: </form:label>
        <form:input type="number" path="age"/>
        <br>
        <form:errors class="text-danger" path="age"/> 
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</div>

</body>
</html>