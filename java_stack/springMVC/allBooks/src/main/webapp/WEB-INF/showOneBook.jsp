<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> <c:out value="${myOwnBook.title}"/></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="one_book_container">
<div class="d-flex justify-content-between"><h1> <c:out value="${myOwnBook.title}"/> </h1>
<a href="/books">Go Back</a>
</div>
<h3>Description: <c:out value="${myOwnBook.description}"/> </h3>
<h3>Language: <c:out value="${myOwnBook.language}"/> </h3>
<h3>Number of pages: <c:out value="${myOwnBook.numberOfPages}"/> </h3>
</div>
</body>
</html>