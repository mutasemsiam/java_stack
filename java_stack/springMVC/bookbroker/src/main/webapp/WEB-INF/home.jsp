<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Lender Dashboard</title>
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
<h2>Hello, <c:out value="${currentUser.userName}"/>. Welcome to..</h2>
<h6><a href="/logout">Logout</a></h6>
</div>

<div class="d-flex justify-content-between">
<h1>The Book Broker!</h1>
<h4><a href="/books/new">+ Add to my shelf!</a></h4>
</div>

<h4>Available Books to Borrow:</h4>
<table class="table table-striped all_books_table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
     
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${unborrowedbooks}">
    <tr>
      <td><c:out value="${book.id}"/></td>
      <td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.user.userName}"/></td>
      <td>
      <c:choose>
    <c:when test="${book.user.id == userId}">
   	<div class="d-flex edit_delete">
    <a href="/books/${book.id}/edit">Edit</a>
     
    <a href="/delete/${book.id}">Delete</a>
    </div>
    
    </c:when>    
    <c:otherwise>
        <a href="/borrow/${book.id}">Borrow</a>
    </c:otherwise>
</c:choose>
      
      
      </td>
      
    </tr>
</c:forEach>
  </tbody>
</table>

<h4>Books I'm Borrowing:</h4>

<table class="table table-striped all_books_table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
     
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${borrowedBooks}">
    <tr>
      <td><c:out value="${book.id}"/></td>
      <td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.user.userName}"/></td>
      <td> <a href="/return/${book.id}">Return</a> </td>
      
    </tr>
</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>