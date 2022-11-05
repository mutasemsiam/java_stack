<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library</title>
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
<h1>All Books</h1>
<div class="mycontainer">
	<table class="table table-striped books_table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col"># Pages</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${allBooks}">
    <tr>
      <td> <c:out value="${book.id}"/></td>
      <td><a href="books/${book.id}"> <c:out value="${book.title}"/> </a></td>
      <td> <c:out value="${book.language}"/></td>
      <td> <c:out value="${book.numberOfPages}"/></td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>