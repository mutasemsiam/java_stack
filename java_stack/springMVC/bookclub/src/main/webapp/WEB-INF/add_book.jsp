<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
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
<h3>Add a book to your shelf!</h3>
<h6><a href="/books">Back to the shelves</a></h6>
</div>
	
	<form:form action="/books/new" method="post" modelAttribute="newBook" class="add_book_form">
				
				<div class="form-group row">
					<form:label path="title" class="col-sm-3 col-form-label">Title: </form:label>
					<div class="col-sm-9">
						<form:input type="text" class="form-control"
							 path="title" />
					</div>
					<form:errors class="text-danger" path="title" />
				</div>

				<div class="form-group row">
					<form:label path="author" class="col-sm-3 col-form-label">Author: </form:label>
					<div class="col-sm-9">
						<form:input type="text" class="form-control"
							path="author" />
					</div>
					<form:errors class="text-danger" path="author" />
				</div>
				<div class="form-group row">
					<form:label path="thoughts" class="col-sm-3 col-form-label">My thoughts: </form:label>
					<div class="col-sm-9">
						<form:input type="text" class="form-control"
							 path="thoughts" />
					</div>
					<form:errors class="text-danger" path="thoughts" />
				</div>
				
				<form:input type="hidden" path="user" value="${userId}"/>

				<div class="col-sm-4 add-button">
					<button type="submit" class="btn btn-primary form-control">Add</button>
				</div>

			</form:form>


</div>

</body>
</html>