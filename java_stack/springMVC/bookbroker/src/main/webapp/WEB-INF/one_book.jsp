<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/style.css" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="container">
<div class="d-flex justify-content-between mynav">
<h3>${thisBook.title}</h3>
<h6><a href="/books">Back to the shelves</a></h6>
</div>

<c:choose>
    <c:when test="${thisBook.user.id == userId}">
        <h4>You read <span style="color:purple">
    ${thisBook.title}</span> by <span style="color:green">${thisBook.author}</span></h4> 
    <h4>Here are your thoughts:</h4>
    <p>${thisBook.thoughts}</p>
    
   	<div class="d-flex edit_delete">
    <a href="/books/${thisBook.id}/edit">Edit</a>
     
    <a href="/delete/${thisBook.id}">Delete</a>
    </div>
    
    </c:when>    
    <c:otherwise>
        <h4><span style="color:red">${thisBook.user.userName}</span> read <span style="color:purple">
    ${thisBook.title}</span> by <span style="color:green">${thisBook.author}</span></h4> 
    <h4>Here are ${thisBook.user.userName}'s thoughts:</h4>
    <p>${thisBook.thoughts}</p>
    </c:otherwise>
</c:choose>
	


</div>



</body>
</html>