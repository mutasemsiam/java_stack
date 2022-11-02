<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css"/>
<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<h2>You have visited <a href="/your_server">http://your_server</a> <c:out value="${countToShow}"></c:out> times </h2>
<a href="/your_server">Test another visit?</a> 
<a href="/your_server/delete">Delete counter</a> 
</body>
</html>